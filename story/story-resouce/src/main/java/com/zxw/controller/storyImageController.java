package com.zxw.controller;


import com.zxw.domain.storyImage;
import com.zxw.service.storyImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/api/storyImage")
public class storyImageController {

        @Autowired
        private storyImageService imageService;

        @PostMapping("/uploads")
        public ResponseEntity<storyImage> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("novelTitle") String novelTitle) {
            storyImage savedImage = imageService.saveImage(file,novelTitle);
            return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
        }

        // 获取所有图片信息
        @GetMapping("/ImageList")
        public List<storyImage> getAllImages() {
            return imageService.getAllImages();
        }

//        // 根据ID获取单个图片信息
//        @GetMapping("/{id}")
//        public ResponseEntity<storyImage> getImageById(@PathVariable Long id) {
//            return imageService.getImageById(id)
//                    .map(ResponseEntity::ok) // 如果图片存在，则返回200状态码和图片数据
//                    .orElse(ResponseEntity.notFound().build()); // 如果图片不存在，则返回404状态码
//        }
    }


