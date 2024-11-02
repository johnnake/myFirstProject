package com.zxw.service;

import com.zxw.domain.ResultVo;
import com.zxw.domain.UserInfo;

import java.util.List;

public interface IUserService {

    String insertUser(UserInfo userInfo);

    Boolean unique(String loginId);

    UserInfo findUserInfoByLoginId(String loginId);

    ResultVo<List<UserInfo>> findList();

    ResultVo<String> updateUserType(UserInfo userInfo);

    ResultVo<String> deleteUser(String userId);
}
