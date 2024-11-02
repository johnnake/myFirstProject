package com.zxw.config;

import com.zxw.domain.UserInfo;
import com.zxw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SecurityUserService implements UserDetailsService {

    @Autowired
    private IUserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userService.findUserInfoByLoginId(username);
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
        return User.withUsername(userInfo.getLoginId())
                .password(userInfo.getPassword())
                .authorities(arr)
                .build();
    }
}
