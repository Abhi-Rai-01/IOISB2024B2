package com.app.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	@Value("${my.data.id}")
	private Integer sid;
	
	@Value("${my.data.name}")
	private String sname;
	
	@Value("${my.data.age}")
	private Integer sage;

	@Value("${my.data.address: IND}")
	private String saddress;
	
	public Student() {
		System.out.println("Student object created using Spring F/W...");
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + "]";
	}
}
