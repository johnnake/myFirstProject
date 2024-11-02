package com.zxw.service.impl;

import com.zxw.dao.StoryResouceDao;
import com.zxw.domain.StoryResouce;
import com.zxw.service.StoryResouceService;
import com.zxw.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryRsouceServiceImpl implements StoryResouceService {
    private final StoryResouceDao storyResouceDao;

    @Autowired
    public StoryRsouceServiceImpl(StoryResouceDao storyResouceDao) {
        this.storyResouceDao = storyResouceDao;
    }
    @Override
    public PageResult<StoryResouce> findStoryResourcesWithPagination(int currentPage, int pageSize) {
        int offset = (currentPage - 1) * pageSize;
        List<StoryResouce> resources = storyResouceDao.findAllWithPagination(offset, pageSize);
        int totalCount = storyResouceDao.getTotalCount();

        PageResult<StoryResouce> pageResult = new PageResult<>();
        pageResult.setDataList(resources);
        pageResult.setPageNo(currentPage);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalCount(totalCount);

        return pageResult;
    }

    @Override
    public int updateStory(StoryResouce storyResouce) {
            // 可以添加额外的业务逻辑验证
            return storyResouceDao.updateStory(storyResouce);
    }

    @Override
    public List<StoryResouce> findAll() {
        //这里可能会组合多个dao层方法的逻辑来达到复杂的效果
        List<StoryResouce> all= storyResouceDao.findAll();
        return all;
    }

    @Override
    public void insert(StoryResouce storyResouce) {
        //调用dao层插入方法
        storyResouceDao.insert(storyResouce);
    }

    @Override
    public  void delete(String id) {
        storyResouceDao.delete(id);
    }

    @Override
    public StoryResouce findById(String id) {
        return storyResouceDao.findById(id);
    }

    @Override
    public List<StoryResouce> findStoriesByImageId(Integer imageId) {
        return storyResouceDao.findStoriesByImageId(imageId);
    }

    @Override
    public PageResult<StoryResouce> findStoriesByImageIdWithPagination(int imageId, int currentPage, int pageSize) {
        //你的SQL查询代码使用了LIMIT子句来限制返回的结果数量，并且你还指定了偏移量OFFSET。在MySQL中，当你使用LIMIT时，OFFSET是可选的，用于指定从哪一行开始返回结果集。
        // 在你的例子中，LIMIT 1,10意味着从结果集的第二行（索引为1）开始，返回10行数据。
        //所以，当你看到查询结果从"第二章 天外之人"开始，其实是因为你设置了OFFSET 1，这忽略了结果集中的第一行（即ID为1的记录"我的父亲是李刚"），然后返回接下来的10行。
        int offset = (currentPage - 1) * pageSize;// 计算偏移量
        List<StoryResouce> resources = storyResouceDao.findStoriesByImageIdWithPagination(imageId,offset, pageSize);
        int totalCount = storyResouceDao.getTotalCountByImageId(imageId);

        PageResult<StoryResouce> pageResult = new PageResult<>();
        pageResult.setDataList(resources);
        pageResult.setPageNo(currentPage);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalCount(totalCount);

        return pageResult;
    }
}
