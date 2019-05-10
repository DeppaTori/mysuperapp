package com.deppatori.mysuperapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
public class MysuperappApplication {
	
	private String allowedOriginUrl = "http://localhost:3006";
	//private String allowedOriginUrl = "https://deppatori.github.io";

	
	public static void main(String[] args) {
		SpringApplication.run(MysuperappApplication.class, args);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/produk/**").allowedOrigins(allowedOriginUrl);
            }
        };
    }

}
