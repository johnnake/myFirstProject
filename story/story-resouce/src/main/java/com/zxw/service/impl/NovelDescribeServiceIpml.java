package com.zxw.service.impl;

import com.zxw.dao.NovelDescribeDao;
import com.zxw.domain.NovelDescribe;
import com.zxw.service.NovelDescribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NovelDescribeServiceIpml implements NovelDescribeService {


    private final NovelDescribeDao novelDescribeDao;

    @Autowired
    public NovelDescribeServiceIpml(NovelDescribeDao novelDescribeDao) {
        this.novelDescribeDao = novelDescribeDao;
    }
    @Override
    public List<NovelDescribe> findNovelDescribeByNovelId(int novelId) {
        List<NovelDescribe> allByNovelId=novelDescribeDao.findNovelDescribeByNovelId(novelId);
        return allByNovelId;
    }

    @Override
    public void insertNovelDescribe(NovelDescribe novelDescribe) {
            novelDescribeDao.insertNovelDescribe(novelDescribe);
    }

    @Override
    public int updateNovelDescribe(NovelDescribe novelDescribe) {
        return novelDescribeDao.updateNovelDescribe(novelDescribe);
    }
}
