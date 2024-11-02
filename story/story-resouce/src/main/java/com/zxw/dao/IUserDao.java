package com.zxw.dao;

import com.zxw.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserDao {

    void insertUser(UserInfo userInfo);

    UserInfo findUserInfoByLoginId(String loginId);

    List<UserInfo> findList();

    void updateUserType(UserInfo userInfo);

    void delete(String userId);
}
