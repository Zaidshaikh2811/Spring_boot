package com.child1.hospital.config;

import com.child1.hospital.interceptor.DoctorInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new DoctorInterceptor()).addPathPatterns("/api/v1/doctors/**");
//        WebMvcConfigurer.super.addInterceptors(registry);

    }
}
