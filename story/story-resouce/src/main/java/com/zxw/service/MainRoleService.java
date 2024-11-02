package com.zxw.service;

import com.zxw.domain.MainRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MainRoleService {


    List<MainRole> findMainRoleByNovelId(@Param("novelId") int novelId);
    void insertMainRole(MainRole mainRole);
    int updateMainRole(MainRole mainRole);

}
