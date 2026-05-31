package in.pw.ioi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.pw.ioi.model.Student;

@Repository("dao")
public class StudentDaoImpl implements IStudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Student student) {
		return jdbcTemplate.update("insert into student(`sid`, `sname`, `email`) values(?, ?, ?)", student.getSid(), student.getSname(), student.getEmail());
	}

	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("Select * from student where sid = ?", 
				new StudentRowMapper(),
				id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
//		return jdbcTemplate.query("Select * from student", new StudentRowMapper());
		return jdbcTemplate.query("Select * from student", 
				new BeanPropertyRowMapper<>(Student.class));
	}

}
