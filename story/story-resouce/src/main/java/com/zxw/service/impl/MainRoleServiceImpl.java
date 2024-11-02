package com.zxw.service.impl;

import com.zxw.dao.MainRoleDao;
import com.zxw.domain.MainRole;
import com.zxw.service.MainRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MainRoleServiceImpl implements MainRoleService {

    private final MainRoleDao mainRoleDao;

    @Autowired
    public MainRoleServiceImpl(MainRoleDao mainRoleDao) {
        this.mainRoleDao = mainRoleDao;
    }
    @Override
    public List<MainRole> findMainRoleByNovelId(int novelId) {
        List<MainRole> allByNovelId=mainRoleDao.findMainRoleByNovelId(novelId);
        return allByNovelId;
    }

    @Override
    public void insertMainRole(MainRole mainRole) {
        mainRoleDao.insertMainRole(mainRole);
    }

    @Override
    public int updateMainRole(MainRole mainRole) {
        return mainRoleDao.updateMainRole(mainRole);
    }
}
