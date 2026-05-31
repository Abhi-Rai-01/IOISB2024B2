package in.pw.ioi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import in.pw.ioi.dao.IStudentDao;
import in.pw.ioi.model.Student;
import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class StudentService {
	
	private IStudentDao dao;

	public StudentService(IStudentDao dao) {
		this.dao = dao;
	}
	
	public Student saveStudent(Student student) {
		System.out.println("Implementation class is: "+dao.getClass().getName());
		return dao.save(student);
	}
	
	@Transactional(readOnly = true)
	public Student findStudentById(Integer id) {
		return dao.findById(id)
				  .orElseThrow(() -> new EntityNotFoundException("Student not found for the given id: "+id));
	}
	
	public void deleteStudentById(Integer id) {
		Optional<Student> optional = dao.findById(id);
		if (optional.isPresent()) {
			dao.deleteById(id);
			System.out.println("Record Deleted Successfully.....");
		} else {
			System.out.println("Record not found for the given id: "+id);
		}
	}
	
	public Student updateStudentById(Integer id) {
		try {
			Student stdPersisted = findStudentById(id);
			stdPersisted.setSname("tendulkar");
			return dao.save(stdPersisted);
			
		} catch (EntityNotFoundException e) {
			throw e;
		}
	}
	
	public boolean studentIdExists(Integer id) {
		return dao.existsById(id);
	}
	
	public Iterable<Student> sortStudentByNameAndAge(boolean sortOrder, String... propertyName) {
		
		Sort sort = Sort.by(sortOrder ? Direction.ASC : Direction.DESC, propertyName);
		return dao.findAll(sort);
	}
	
	public Iterable<Student> sortStudentByNameAndAge(String... propertyName) {
		
		Sort sort = Sort.by(Sort.Order.asc(propertyName[0]), Sort.Order.desc(propertyName[1]));
		return dao.findAll(sort);
	}
	
	public List<Student> sortAndDisplayRecords(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Student> page = dao.findAll(pageable);
		
		return page.getContent();
	}
	
	public List<Student> sortAndDisplayRecords(boolean sortOrder, int pageNo, int pageSize, String... properties) {
		Sort sort = Sort.by(sortOrder ? Direction.ASC : Direction.DESC, properties);
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Student> page = dao.findAll(pageable);
		
		return page.getContent();
	}

	public List<Student> sortAndDisplayRecords(int pageNo, int pageSize, String... properties) {
		Sort sort = Sort.by(Sort.Order.asc(properties[0]), Sort.Order.desc(properties[1]));
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Student> page = dao.findAll(pageable);
		
		return page.getContent();
	}
	
	public List<Student> findStudentDetailsUsingNameAndAge(String name, Integer age){
		
		Student std = new Student();
		std.setSname(name);
		std.setSage(age);
		
		Example<Student> probe = Example.of(std);
		return dao.findAll(probe);
		
		/*
		 * Select all columns 
		 * 		from student 
		 * 			where sname = '' 
		 * 				  and 
		 * 				  sage = ''
		 */
	}
	
	public List<Student> findStudentsUsingLikeOperation(String name){
		Student probe = new Student();
		probe.setSname(name);
		
		ExampleMatcher matcher = ExampleMatcher.matching()
											   .withIgnoreCase()
											   .withStringMatcher(StringMatcher.ENDING);
		
		Example<Student> example = Example.of(probe, matcher);
		List<Student> students = dao.findAll(example);
		System.out.println("No. of records: " + students.size());
		
		return students;
	}
	
	public List<Student> findStudentsUsingNameAndAgeCondition(String name, Integer age){
		Student probe = new Student();
		probe.setSname(name);
		probe.setSage(age);
		
		ExampleMatcher matcher = ExampleMatcher.matchingAny()// OR
											   .withMatcher("sname", userName->userName.contains().ignoreCase()) // name LIKE '%data%'
											   .withMatcher("sage", userAge->userAge.exact()); // marks = ?
		
		Example<Student> example = Example.of(probe, matcher);
		List<Student> students = dao.findAll(example);
		System.out.println("No. of records: " + students.size());
		
		return students;
	}
}
