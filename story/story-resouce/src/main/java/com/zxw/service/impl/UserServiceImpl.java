package com.zxw.service.impl;

import com.zxw.dao.IUserDao;
import com.zxw.domain.ResultVo;
import com.zxw.domain.UserInfo;
import com.zxw.service.IUserService;
import com.zxw.util.ResultVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String insertUser(UserInfo userInfo) {
        //对密码加密
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        //实现插入数据
        userDao.insertUser(userInfo);
        return "success";
    }

    @Override
    public Boolean unique(String loginId) {
        UserInfo userInfo = userDao.findUserInfoByLoginId(loginId);
        return userInfo==null;
    }

    @Override
    public UserInfo findUserInfoByLoginId(String loginId) {
        return userDao.findUserInfoByLoginId(loginId);
    }

    @Override
    public ResultVo<List<UserInfo>> findList() {
        List<UserInfo> list = userDao.findList();
        return ResultVoUtil.success(list);
    }

    @Override
    public ResultVo<String> updateUserType(UserInfo userInfo) {
        userDao.updateUserType(userInfo);
        return ResultVoUtil.success(null);
    }

    @Override
    public ResultVo<String> deleteUser(String userId) {
        userDao.delete(userId);
        return ResultVoUtil.success(null);
    }
}
