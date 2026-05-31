package in.pw.ioi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentTab")
public class StudentTable {
	
	@Column(name="stdId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id // primary key
	private Integer sid;
	
	@Column
	private String sname;
	
	@Column(name="stdAge")
	private Integer sage;
	
	@Column(name="stdAddress")
	private String saddress;
	
	public StudentTable() {
		super();
		System.out.println("Used by hibernate during creation of object: merge()");
	}

	public StudentTable(Integer sid , String sname, Integer sage, String saddress) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
	}
	
	public StudentTable(String sname, Integer sage, String saddress) {
		super();
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
	}

	@Override
	public String toString() {
		return "StudentTable [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + "]";
	}
}
