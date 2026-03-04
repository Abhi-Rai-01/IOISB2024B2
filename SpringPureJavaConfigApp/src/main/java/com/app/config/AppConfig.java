package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.bean.Token;

@Configuration
public class AppConfig {
	
	@Bean // public ClassName reference(){// logic to create the object}
	public Token obj1() {
		Token token = new Token();
		token.setCode(10);
		return token;
	}
	
	@Bean
	public Token obj2() {
		Token token = new Token();
		token.setCode(10);
		return token;
	}
}
