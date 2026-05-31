package in.pw.ioi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.pw.ioi.config.AppConfig;
import in.pw.ioi.dao.IStudentDao;
import in.pw.ioi.model.Student;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext cfg = new AnnotationConfigApplicationContext(AppConfig.class);

		IStudentDao dao = cfg.getBean("dao", IStudentDao.class);
		
		Student std = new Student();
		std.setSid(45);
		std.setSname("Rohith");
		std.setEmail("Rohith@mi.com");
		
		int noOfRecords = dao.save(std);
		System.out.println("No of Record updated is: "+noOfRecords);
		
		
		cfg.close();
	}

}
