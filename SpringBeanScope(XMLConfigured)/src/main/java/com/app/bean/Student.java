package com.app.bean;

public class Student {
	private Integer sid;
	private String sname;
	private String saddress;
	
	static {
		System.out.println("**********Bean Loading***********");
	}

	public Student() {
		super();
		System.out.println("***********Bean Instantiation**********");
	}

	public void setSid(Integer sid) {
		System.out.println("***********Bean Initialization**********");
		this.sid = sid;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + "]";
	}
}
