package com.zxw.service;


import com.zxw.domain.ResultVo;
import com.zxw.domain.StoryResouce;
import com.zxw.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoryResouceService {

    PageResult<StoryResouce> findStoryResourcesWithPagination(@Param("offset") int offset, @Param("limit") int limit);

    int updateStory(StoryResouce storyResouce);

    List<StoryResouce> findAll();

    void insert(StoryResouce storyResouce);

    void delete(String id);

    StoryResouce findById(String id);

    List<StoryResouce> findStoriesByImageId(Integer imageId);

    PageResult<StoryResouce> findStoriesByImageIdWithPagination(@Param("imageId") int imageId,
                                                          @Param("offset") int offset,
                                                          @Param("limit") int limit);
}
