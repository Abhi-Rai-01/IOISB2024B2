package in.pw.ioi.model;

public class Student {
	private Integer sid;
	private String sname;
	private String email;

	public Student() {
		super();
	}
	
	public Student(Integer sid, String sname, String email) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.email = email;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", email=" + email + "]";
	}	
}
