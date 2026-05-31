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
		StudentTable attachedObj = null;
		try {
			StudentTable std = new StudentTable(6, "Nitin", 28, "Bengaluru");
			attachedObj = session.merge(std);// update query ===> send to db for execution: result ===> cache
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		
		if (flag) {
			System.in.read();
			transaction.commit();// cache -> saved to database
			System.out.println("Record saved to database: "+attachedObj);
		} else {
			transaction.rollback();
			System.out.println("Record not saved to database");
		}
	}
}
