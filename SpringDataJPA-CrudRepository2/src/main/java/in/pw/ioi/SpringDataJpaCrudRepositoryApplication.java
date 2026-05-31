package in.pw.ioi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.pw.ioi.model.Student;
import in.pw.ioi.service.StudentService;
import jakarta.persistence.EntityNotFoundException;

@SpringBootApplication
public class SpringDataJpaCrudRepositoryApplication implements CommandLineRunner{
	private StudentService stdService;
	
	public SpringDataJpaCrudRepositoryApplication(StudentService stdService) {
		this.stdService = stdService;
	}

	public static void main (String[] args) {
		System.out.println("***********************Container started****************************");
		SpringApplication.run(SpringDataJpaCrudRepositoryApplication.class, args);
		System.out.println("***********************Container stopped****************************");
	}

	@Override
	public void run(String... args) throws Exception {
//		Student student = new Student();
//		student.setSid(6);
//		student.setSname("yuvraj");
//		student.setSage(43);
//		student.setEmail("yuvi@punjab.com");
//		 
//		Student stdPersisted = stdService.saveStudent(student);
//		System.out.println(stdPersisted);
		 
		 
//		try { 
//			Student std = stdService.findStudentById(2); 
//		 	System.out.println(std); }
//		catch (EntityNotFoundException e) { 
//		 	// TODO: handle exception
//		 	System.out.println(e.getMessage()); 
//		}
		
		
//		stdService.deleteStudentById(2);
		
		
//		Student std = stdService.updateStudentById(2);
//		System.out.println("Updated info: "+ std);
		
		
//		boolean idExists = stdService.studentIdExists(2);
//		System.out.println(idExists);
		
		
//		********************Sorting*****************************
		
//		stdService.sortStudentByNameAndAge(false, "sname", "sage")
//				  .forEach(student -> System.out.println(student));
		
		
//		stdService.sortStudentByNameAndAge("sname", "sage")
//				  .forEach(student -> System.out.println(student));

		
//		********************Pagination***************************
		
//		stdService.sortAndDisplayRecords(3, 5)
//				  .forEach(student -> System.out.println(student));


//		********************Pagination with Sorting****************

//		stdService.sortAndDisplayRecords(false, 0, 5, "sname", "sage")
//				  .forEach(student -> System.out.println(student));
		
//		stdService.sortAndDisplayRecords(0, 5, "sname", "sage")
//		.forEach(student -> System.out.println(student));
		
		
//		******************Reading with JpaRepository**************
		
//		stdService.findStudentDetailsUsingNameAndAge("janhavi", 20)
//				  .forEach(student -> System.out.println(student));

		
//		******************Reading with Like Operation**************
//		using Example, ExampleMatcher
		
//		stdService.findStudentsUsingLikeOperation("i")
//			      .forEach(student -> System.out.println(student));
		
		stdService.findStudentsUsingNameAndAgeCondition("m", 20)
				  .forEach(std->System.out.println(std));
	}
}