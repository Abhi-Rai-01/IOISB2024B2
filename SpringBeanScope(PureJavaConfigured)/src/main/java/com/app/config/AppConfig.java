package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.app.bean.Student;

@Configuration
@Lazy
public class AppConfig {
	
	@Bean
	@Scope("prototype")
	public Student std1() {
		Student std = new Student();
		std.setSid(18);
		std.setSname("Kholi");
		std.setSaddress("IND");
		return std;
	}

	@Bean
	@Scope("prototype")
	public Student std2() {
		Student std = new Student();
		std.setSid(18);
		std.setSname("Kholi");
		std.setSaddress("IND");
		return std;
	}
}