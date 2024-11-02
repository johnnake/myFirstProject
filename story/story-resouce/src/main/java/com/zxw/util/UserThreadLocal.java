package com.zxw.util;

import com.zxw.domain.UserInfo;

public class UserThreadLocal {
    public static ThreadLocal<UserInfo> userInfoThreadLocal= new ThreadLocal<>();
}
