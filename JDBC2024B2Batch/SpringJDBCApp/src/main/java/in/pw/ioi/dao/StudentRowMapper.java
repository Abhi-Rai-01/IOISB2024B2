package in.pw.ioi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.pw.ioi.model.Student;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("Magical methods: "+ rowNum);
		
		Student std = new Student();
		std.setSid(rs.getInt(1));
		std.setSname(rs.getString(2));
		std.setEmail(rs.getString(3));
		return std;
	}

}
