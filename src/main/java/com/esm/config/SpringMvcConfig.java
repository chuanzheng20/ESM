package com.esm.config;


import com.esm.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/*","/*/*")
                .excludePathPatterns("/pages/login.html")
                .excludePathPatterns("/error")
                .excludePathPatterns("/css","/css/*")
                .excludePathPatterns("/js","/js/*");



    }
}

