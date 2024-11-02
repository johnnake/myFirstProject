package com.zxw.controller;

import com.zxw.domain.ResultVo;
import com.zxw.domain.UserInfo;
import com.zxw.service.IUserService;
import com.zxw.util.ResultVoUtil;
import com.zxw.util.TokenUtil;
import com.zxw.util.UserCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class LoginController {

    private final static Logger  LOGGER=LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody Map<String,String> param){
        LOGGER.info("--开始认证--");
        Map<String,Object> map = new HashMap<>();
        //调用认证管理器来认证
        try {
            String loginId=param.get("loginId");
            String password=param.get("password");
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginId,password);
            Authentication authenticate = authenticationManager.authenticate(authenticationToken);
            if(null!=authenticate){
                //认证成功了
                //生成token,把token放在返回值里,返回给前端
                String token = TokenUtil.createToken();
                //查询用户对象
                UserInfo userInfo = userService.findUserInfoByLoginId(loginId);
                userInfo.setToken(token);
                userInfo.setPassword("");
                //缓存里头放用户对象
                UserCache.put(token,userInfo);
                map.put("code","200");
                map.put("data",userInfo);
                map.put("message","success");
            }else{
                map.put("code","500");
                map.put("data","认证失败");
            }
        } catch (AuthenticationException e) {
            LOGGER.error("认证异常:",e);
            map.put("code","500");
            map.put("data","认证异常");
        }
        LOGGER.info("认证结束");
        return map;
    }

    @GetMapping("/logout")
    public ResultVo<String> logout(@RequestHeader("Authorize") String token){
        //删除缓存中用户信息
        LOGGER.info("用户注销:{}",token);
        UserCache.remove(token);
        return ResultVoUtil.success(null);
    }
}
