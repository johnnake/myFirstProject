package com.zxw.controller;

import com.zxw.domain.ResultVo;
import com.zxw.domain.UserInfo;
import com.zxw.service.IUserService;
import com.zxw.util.ResultVoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    private final  static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public ResultVo<String> register(@RequestBody UserInfo userInfo){
        try {
            String s = userService.insertUser(userInfo);
            return ResultVoUtil.success(s);
        } catch (Exception e) {
            LOGGER.error("register error:",e);
            return  ResultVoUtil.error(e,1001);
        }
    }

    @GetMapping("/unique")
    public ResultVo<Boolean> unique(@RequestParam String loginId){
        try {
            Boolean unique = userService.unique(loginId);
            return ResultVoUtil.success(unique);
        } catch (Exception e) {
            LOGGER.error("unique error:",e);
            return  ResultVoUtil.error(e,1002);
        }
    }

    @GetMapping("/list")
    public ResultVo<List<UserInfo>> findList(){
        try {
            return userService.findList();
        } catch (Exception e) {
            LOGGER.error("用户列表查询失败:",e);
            return  ResultVoUtil.error(e,1003);
        }
    }

    @PostMapping("/updateUserType")
    public ResultVo<String> updateUserType(@RequestBody UserInfo userInfo){
        try {
            return userService.updateUserType(userInfo);
        } catch (Exception e) {
            LOGGER.error("更新用户状态失败:",e);
            return  ResultVoUtil.error(e,1004);
        }
    }

    @GetMapping("/deleteUser")
    public ResultVo<String> deleteUser(@RequestParam("userId") String userId){
        try {
            return userService.deleteUser(userId);
        } catch (Exception e) {
            LOGGER.error("删除用户失败:",e);
            return  ResultVoUtil.error(e,1005);
        }
    }
}
