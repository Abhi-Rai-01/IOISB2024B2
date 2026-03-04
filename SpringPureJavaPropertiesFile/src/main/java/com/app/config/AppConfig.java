package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.app.bean.DbConfig;

@Configuration
@PropertySource("classpath:myDb.properties")
public class AppConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public DbConfig obj() {
		DbConfig config = new DbConfig();
		config.setUsername(env.getProperty("my.db.userName"));
		config.setPassword(env.getProperty("my.db.password"));
		System.out.println(env.getClass().getName());
		System.out.println("************************");
		return config;
	}
}
