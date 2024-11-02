package com.zxw.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class storyImage {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) // 对于支持自增的数据库如MySQL
        private Long id;
        private String imageName;
        private String imageUrl;
        private String novelTitle;
        private int userId;

        // Getters and Setters
}

