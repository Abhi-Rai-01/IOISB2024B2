package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.bean.Student;

public class TestApp {

	public static void main(String[] args) {
		System.out.println("***************Container Started**************");
		// 1. start the container
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. ask the container to get the bean
		Student s = container.getBean("s0",Student.class);
		Student s0 = container.getBean("s0",Student.class);
		Student s1 = container.getBean("s1",Student.class);
		Student s2 = container.getBean("s2",Student.class);
		
		// 3. use the bean
		System.out.println(s);
		System.out.println(s0);
		System.out.println(s==s0);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1==s2);
		System.out.println(s==s1);
		System.out.println(s==s2);
		
		// 4. close the container
		((AbstractApplicationContext) container).close();
		System.out.println("***************Container Closed**************");
	}
}
