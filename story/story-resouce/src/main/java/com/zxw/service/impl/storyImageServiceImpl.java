package com.zxw.service.impl;
import com.zxw.dao.storyImageRepository;
import com.zxw.domain.UserInfo;
import com.zxw.domain.storyImage;
import com.zxw.service.storyImageService;
import com.zxw.util.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class storyImageServiceImpl implements storyImageService {

        private final String UPLOAD_DIR = "D:\\storyPicture"; // 设置你的上传目录
        private final storyImageRepository imageRepository;

        @Autowired
        public storyImageServiceImpl(storyImageRepository imageRepository) {
        this.imageRepository = imageRepository;
        }

        @Override
        public storyImage saveImage(MultipartFile file,String novelTitle) {
            try {
                // 保存文件到指定目录
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                Path path = Paths.get(UPLOAD_DIR + File.separator + fileName);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                // 如果需要，保存到数据库
                UserInfo userInfo = UserThreadLocal.userInfoThreadLocal.get();
                storyImage image = new storyImage();
                image.setImageName(fileName);
                image.setImageUrl("http://localhost:8084/static/" + fileName); // 假设uploads是web访问的相对路径
                image.setNovelTitle(novelTitle); // 假设storyImage类中有一个setNovelTitle方法
                image.setUserId(userInfo.getUserId());
                return imageRepository.save(image); // 假设有一个imageRepository
            } catch (IOException e) {
                throw new RuntimeException("Failed to store file " + file.getOriginalFilename(), e);
            }
        }

        @Override
        public List<storyImage> getAllImages() {
//                UserInfo userInfo = UserThreadLocal.userInfoThreadLocal.get();
//                return imageRepository.findAllByUserId(userInfo.getUserId());
            return imageRepository.findAll();
        }

//        @Override
//        public Optional<storyImage> getImageById(Long id) {
//            return imageRepository.findById(id);
//        }
}


