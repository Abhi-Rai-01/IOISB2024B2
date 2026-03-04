package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.app.bean.Token;
import com.app.config.AppConfig;

public class TestApp {

	public static void main(String[] args) {
		// 1. start the container
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		
		String msg = container.getBeanDefinition("obj1").getResourceDescription();
		System.out.println("onject created using: " + msg);
		
		// 2. Ask the container to get the beans
		Token t1 = container.getBean("obj1", Token.class);
		Token t2 = container.getBean("obj2", Token.class);
		
		// 3. use the bean
		System.out.println(t1);
		System.out.println(t1.hashCode());
		System.out.println(t2);
		System.out.println(t2.hashCode());
		
		//4. close the container
		((AbstractApplicationContext) container).close();
	}

}
