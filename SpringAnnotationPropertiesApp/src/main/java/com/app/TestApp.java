package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.app.bean.Student;
import com.app.config.AppConfig;

public class TestApp {

	public static void main(String[] args) {
		//1. Start the container
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//2. ask the container to get the bean
		Student std = container.getBean("student", Student.class); // id = "student"
		
		//3. use the bean
		System.out.println(std);
		
		//4. close the container
		container.close();
	}

}
