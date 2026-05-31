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
public class StudentTable implements Serializable {
	
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

	public StudentTable(String sname, Integer sage, String saddress) {
		super();
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
	}
}
