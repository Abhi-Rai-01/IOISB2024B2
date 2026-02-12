package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.app.config.AppConfig;
import com.app.service.StudentService;

public class TestApp {

	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[] beanNames = container.getBeanDefinitionNames();
		for (String bean : beanNames) {
			System.out.println(bean);
		}
		
		StudentService service = container.getBean("service", StudentService.class);
		System.out.println(service);
		
		((AbstractApplicationContext) container).close();
	}
}
