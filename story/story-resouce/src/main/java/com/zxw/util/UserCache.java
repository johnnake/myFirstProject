package com.zxw.util;

import com.zxw.domain.UserInfo;

import java.util.HashMap;
import java.util.Map;

public class UserCache {
    private static Map<String, UserInfo> map = new HashMap<>();

    public static void put(String token,UserInfo userInfo){
        map.put(token,userInfo);
    }

    public static UserInfo get(String token){
        return map.get(token);
    }

    public static void remove(String token){
        map.remove(token);
    }
}
