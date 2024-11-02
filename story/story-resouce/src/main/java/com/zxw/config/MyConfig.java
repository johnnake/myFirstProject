package com.zxw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/html/**").addResourceLocations("classpath:/html/");
        //处理js资源
//        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        //处理图片资源
//        registry.addResourceHandler("/storyPicture/**").addResourceLocations("file:D:/storyPicture/");
    }
}
