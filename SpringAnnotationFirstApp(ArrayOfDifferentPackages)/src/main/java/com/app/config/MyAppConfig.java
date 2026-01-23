package com.app.config;

import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"com.app.bean"})
public class MyAppConfig {
	static {
		System.out.println("MyAppConfig.class file is loading...");
	}

	public MyAppConfig() {
		System.out.println("MyAppConfig object is created by Spring F/W....");
	}
}
