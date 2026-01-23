package com.app.bean;

public class Student {	
	private Integer sid;
	private String sname;
	private Integer sage;
	
	static {
		System.out.println("Student.class file loading by SpringF/w...");
	}
	
	public Student(Integer sid, String sname, Integer sage) {
		super();
		System.out.println("Student Object is created using Constructor by SpringF/W.....");
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + "]";
	}
}
