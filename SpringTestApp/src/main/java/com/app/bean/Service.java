package com.app.bean;

import org.springframework.stereotype.Component;

@Component
public class Service {

	public Service() {
		super();
		System.out.println("Object created using @Component.......");
	}
	
	public void doWork() {
		System.out.println("I am doing some work............");
	}
	
}
