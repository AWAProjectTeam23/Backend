package com.example.restapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/public/**")
                .allowedOrigins("*")
                .allowedHeaders("*");
        registry.addMapping("/customer/**")
                .allowedOrigins("*")
                .allowedHeaders("*");
        registry.addMapping("/manager/**")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }
}
