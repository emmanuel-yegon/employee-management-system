package com.employee.mgmt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Replace "/api/**" with your API base path
                .allowedOrigins("http://localhost:3000") // Replace with the origin of your frontend application
                .allowedMethods("PATCH","PUT","POST","GET","DELETE","OPTIONS") // Allowed HTTP methods
                .allowedHeaders("Content-Type","X-Requested-With", "accept", "Origin", "Access-Control-Request-Method","Access-Control-Request-Headers")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")// Allowed request headers
                .allowCredentials(true);
    }

}
