package com.app.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("std") // Student std = new Student();
public class Student {
	static {
		System.out.println("Student.class file is loading....");
	}
	
	@Value("10") // field injection
	private Integer sid;
	
	@Value("sachin") // field injection
	private String sname;
	
	@Value("55") // field injection
	private Integer sage;

	public Student() {
		System.out.println("Student object created by SpringF/W....");
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + "]";
	}
}
