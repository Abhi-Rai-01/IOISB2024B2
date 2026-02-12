package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.service.ExcelExportService;

public class TestApp {

	public static void main(String[] args) throws Exception {
		//1. start the container
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2. ask the container to get the bean
		ExcelExportService service = container.getBean("service", ExcelExportService.class);
		
		//3. use the bean
		System.out.println(service);
		
		//4. close the container
		Thread.sleep(5000);
		((AbstractApplicationContext) container).close();
		
	}

}
