package com.zxw.service;

import com.zxw.domain.NovelDescribe;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NovelDescribeService {

    List<NovelDescribe> findNovelDescribeByNovelId(@Param("novelId") int novelId);

    void insertNovelDescribe(NovelDescribe novelDescribe);

    int updateNovelDescribe(NovelDescribe novelDescribe);

}
