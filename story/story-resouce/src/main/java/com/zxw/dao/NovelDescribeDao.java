package com.zxw.dao;

import com.zxw.domain.NovelDescribe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface NovelDescribeDao {

    List<NovelDescribe> findNovelDescribeByNovelId(@Param("novelId") int novelId);

    void insertNovelDescribe(NovelDescribe novelDescribe);

    int updateNovelDescribe(NovelDescribe novelDescribe);
}
