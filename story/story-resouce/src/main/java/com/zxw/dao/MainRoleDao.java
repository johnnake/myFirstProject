package com.zxw.dao;

import com.zxw.domain.MainRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface MainRoleDao {

    List<MainRole> findMainRoleByNovelId(@Param("novelId") int novelId);
    void insertMainRole(MainRole mainRole);
    int updateMainRole(MainRole mainRole);

}
