package in.pw.ioi.model;

public class Product {
	private Integer pid;
	private String pname;
	private Integer pcost;
	private String ptype;
	
	public Product() {
	}

	public Product(Integer pid, String pname, Integer pcost, String ptype) {
		this.pid = pid;
		this.pname = pname;
		this.pcost = pcost;
		this.ptype = ptype;
	}


	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPcost() {
		return pcost;
	}
	public void setPcost(Integer pcost) {
		this.pcost = pcost;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pcost=" + pcost + ", ptype=" + ptype + "]";
	}
}
