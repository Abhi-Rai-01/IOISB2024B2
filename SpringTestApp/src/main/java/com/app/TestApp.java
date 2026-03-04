package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.app.bean.Service;
import com.app.config.AppConfig;

public class TestApp {

	public static void main(String[] args) {
		// 1. start the container
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println(container.getBeanDefinition("service").getResourceDescription());
		
		// 2. ask the container to get the bean
		Service service = container.getBean("service", Service.class);
		
		// 3. use the bean
		service.doWork();
		
		// 4. close the container
		((AbstractApplicationContext) container).close();
	}
}
