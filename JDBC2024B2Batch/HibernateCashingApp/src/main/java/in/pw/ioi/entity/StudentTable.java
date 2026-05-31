package in.pw.ioi.entity;

import java.io.Serializable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentTab")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class StudentTable implements Serializable{
	
	/**
	 * 
	 */
	// was not in the lecture I myself added it
	private static final long serialVersionUID = 1L;

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
		System.out.println("Used by hibernate during creation of object");
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

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	@Override
	public String toString() {
		return "StudentTable [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + "]";
	}
}
