package com.app.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("s1")
@Scope("prototype")
@Lazy
public class Student {
	
	@Value("10")
	private Integer sid;

	@Value("sachin")
	private String sname;
	
	@Value("IND")
	private String saddress;
	
	static {
		System.out.println("**********Bean Loading***********");
	}

	public Student() {
		super();
		System.out.println("***********Bean Instantiation**********");
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + "]";
	}
}
