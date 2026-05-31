package in.pw.ioi;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.pw.ioi.entity.StudentTable;

public class TestApp {

	public static void main(String[] args) throws IOException {
		// Step 1: Activate HIBERNATE Environment
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		boolean flag = false;
		try {
			StudentTable std = new StudentTable("Aditya", 20, "Madhya Pradesh");
			session.persist(std);// insert query ===> send to db for execution: result ===> cache
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		
		if (flag) {
			System.in.read();
			transaction.commit();// cache -> saved to database
			System.out.println("Record saved to database");
		} else {
			transaction.rollback();
			System.out.println("Record not saved to database");
		}
	}
}
