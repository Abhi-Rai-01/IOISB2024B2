package com.app.bean;

public class Student {	
	private Integer sid;
	private String sname;
	private Integer sage;
	
	static {
		System.out.println("Student.class file loading by SpringF/w...");
	}
	public Student() {
		System.out.println("Student object is created by SpringF/w....");
		System.err.println(this.toString());
	}
	
	public void setSid(Integer sid) {
		System.out.println("SID is injected by the SpringF/w using setter");
		this.sid = sid;
	}
	public void setSname(String sname) {
		System.out.println("SNAME is injected by the SpringF/w using setter");
		this.sname = sname;
	}
	public void setSage(Integer sage) {
		System.out.println("SAGE is injected by the SpringF/w using setter");
		this.sage = sage;
		System.err.println(this.toString());
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + "]";
	}
}
