package com.zxw.filter;

import com.zxw.domain.UserInfo;
import com.zxw.util.UserCache;
import com.zxw.util.UserThreadLocal;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TokenFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取用户传递的token(放在请求头),验证
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = httpServletRequest.getHeader("Authorize");
        UserInfo userInfo = UserCache.get(token);
        if(userInfo!=null){
            //认证成功了
          // 获取用户，用ThreadLocal传递,在同一个线程之间共享数据
            UserThreadLocal.userInfoThreadLocal.set(userInfo);
            //设置到spring security
            //创建 userDetails 便于获取权限数据
            //设置真正的权限数据
            String[] arr;
            if("1".equals(userInfo.getUserType())){
                //当前用户是管理员
                arr=new String[2];
                arr[0]="admin";
                arr[1]="custom";
            }else{
                //当前用户是普通用户
                arr=new String[1];
                arr[0]="custom";
            }
            UserDetails userDetails = User.withUsername(userInfo.getLoginId())
                    .password(userInfo.getPassword())
                    .authorities(arr)
                    .build();
            SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
            UsernamePasswordAuthenticationToken auth2=
                    new UsernamePasswordAuthenticationToken(userInfo.getUsername(),userInfo.getPassword(),userDetails.getAuthorities());
            emptyContext.setAuthentication(auth2);
            SecurityContextHolder.setContext(emptyContext);
        }

        filterChain.doFilter(httpServletRequest,servletResponse);
    }
}
