package com.zxw.dao;

import com.zxw.domain.StoryResouce;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoryResouceDao {

    // 分页查询StoryResource
    List<StoryResouce> findAllWithPagination(@Param("offset") int offset, @Param("limit") int limit);

    // 查询总记录数
    int getTotalCount();

    int updateStory(StoryResouce storyResouce);
    List<StoryResouce> findAll();

    void insert(StoryResouce storyResouce);

    void delete(String id);

    StoryResouce findById(String id);

    /**
     * 根据story_image的id查询关联的story1数据
     * @param imageId story_image表的id
     * @return 相关的StoryResouce列表
     */
    List<StoryResouce> findStoriesByImageId(Integer imageId);

    List<StoryResouce> findStoriesByImageIdWithPagination(@Param("imageId") int imageId,
                                                               @Param("offset") int offset,
                                                               @Param("limit") int limit);

    int getTotalCountByImageId(@Param("imageId") int imageId);

}
