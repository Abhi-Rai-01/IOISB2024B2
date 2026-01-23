package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.app.bean.OrderService;

public class TestApp {

	public static void main(String[] args) {
		
		//1. Start the container
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2. Ask the container to get the object
		OrderService service = container.getBean(OrderService.class);
		
		//3. use the bean
		service.order();
		
		//4. close the container
		((AbstractApplicationContext)container).close();
	}
}
