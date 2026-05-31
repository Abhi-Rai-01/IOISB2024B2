package in.pw.ioi;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.pw.ioi.config.AppConfig;
import in.pw.ioi.dao.IStudentDao;
import in.pw.ioi.model.Student;

public class TestApp2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext cfg = new AnnotationConfigApplicationContext(AppConfig.class);

		IStudentDao dao = cfg.getBean("dao", IStudentDao.class);
		
		Student student = dao.findById(10);
		System.out.println(student);
		
		System.out.println("****************************");
		System.in.read();
		
		List<Student> std = dao.findAll();
		std.forEach(System.out::println);
		
		
		cfg.close();
	}

}
