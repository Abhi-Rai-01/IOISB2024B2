package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.app.bean.Service;

@Configuration
@ComponentScan("com.app")
public class AppConfig {
	
	@Bean
	public Service service() {
		System.out.println("Object created using @Bean.............");
		Service service = new Service();
		return service;
	}
}
