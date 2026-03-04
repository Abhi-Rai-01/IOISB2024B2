package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.app.bean.Student;
import com.app.config.AppConfig;

public class TestApp {

	public static void main(String[] args) {
		System.out.println("***************Container Started**************");
		// 1. start the container
		ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// 2. ask the container to get the bean
		Student s1 = container.getBean("s1",Student.class);
		Student s2 = container.getBean("s1",Student.class);
		
		// 3. use the bean
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1==s2);
		
		// 4. close the container
		((AbstractApplicationContext) container).close();
		System.out.println("***************Container Closed**************");
	}
}
