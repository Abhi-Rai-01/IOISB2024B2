package com.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.app.bean"})
@PropertySource("classpath:mydata.properties")
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig object created......");
	}
	
}
