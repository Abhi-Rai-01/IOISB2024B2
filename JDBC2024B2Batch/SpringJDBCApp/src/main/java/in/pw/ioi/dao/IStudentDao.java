package in.pw.ioi.dao;

import java.util.List;

import in.pw.ioi.model.Student;

public interface IStudentDao {
	int save(Student student);
	int update(Student student);
	int deleteById(int id);
	Student findById(int id);
	List<Student> findAll();
}
