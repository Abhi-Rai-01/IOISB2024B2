package com.app;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.app.bean.Student;

public class TestApp {

	public static void main(String[] args) {
		
		//1.Starting the container
		System.out.println("Starting the container.....");
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2. use the object inside the container
		Student std1 = container.getBean(Student.class);
		System.out.println("*************************************************");
		System.out.println(std1);
		
//		Student std2 = container.getBean(Student.class);
//		System.out.println("*************************************************");
//		System.out.println(std2);
		
		//3. close the container
		((AbstractApplicationContext) container).close();
		System.out.println("Closing the container.....");
		
	}

}
