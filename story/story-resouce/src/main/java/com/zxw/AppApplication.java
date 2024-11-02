package com.zxw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class,args);
    }
//    //cors是跨域资源共享的简称
//    @Bean
//    public FilterRegistrationBean corsFilterBean(){
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("http://192.168.10.112:5173");
//        corsConfiguration.addAllowedMethod("GET");
//        corsConfiguration.addAllowedMethod("POST");
//        corsConfiguration.addAllowedHeader("Content-Type");
//        corsConfiguration.setAllowCredentials(false);
//        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        corsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
//        CorsFilter corsFilter = new CorsFilter(corsConfigurationSource);
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(corsFilter);
//        registrationBean.addUrlPatterns("/*");
//        return registrationBean;
//    }

}
