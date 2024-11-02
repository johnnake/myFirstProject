package com.zxw.service;

import com.zxw.domain.storyImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface storyImageService {

        storyImage saveImage(MultipartFile file,String novelTitle);

        /**
         * 获取所有图片列表
         * @return 图片列表
         */
        List<storyImage> getAllImages();

        /**
         * 根据ID获取图片详情
         * @param id 图片ID
         * @return 图片详情的Optional对象，若不存在则返回空Optional
         */
//        Optional<storyImage> getImageById(Long id);

        // 根据需要，可以在这里添加更多的业务方法声明
}


