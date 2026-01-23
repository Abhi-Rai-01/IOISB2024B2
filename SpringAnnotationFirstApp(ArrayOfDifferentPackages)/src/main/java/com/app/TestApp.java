package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.app.bean.Student;
import com.app.config.MyAppConfig;

public class TestApp {

	public static void main(String[] args) {
		//1. start the container
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(MyAppConfig.class);
		/**
		 * this comes in handy if you are not using any external config like MyAppConfig
		 * container.scan("com.app"); container.refresh();
		 */
		
		//2. ask the container to give the object
		Student student= container.getBean(Student.class);
		
		//3. use the object
		System.out.println(student);
		
		//4. close the container
		container.close();
	}

}
