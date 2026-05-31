package in.pw.ioi;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.pw.ioi.entity.StudentTable;

public class TestApp {

	public static void main(String[] args) throws IOException {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		//check in L1 not there, Check in L2 not there
		//hit db ---> select query is generated
		StudentTable std = session.find(StudentTable.class,1);
		System.out.println(std);
		System.in.read();//Thread is paused

		//Get it from L1 Cache
		std = session.find(StudentTable.class, 1);
		System.out.println(std);
		
		//remove from L1 cache
		session.evict(std);
		System.out.println("Object is removed from L1Cache");
		System.in.read();//Thread is paused

		// L1 not there, L2 available -> give it to L1 --> L1 to application
		std = session.find(StudentTable.class, 1);
		System.out.println(std);
		
		System.in.read();//Thread is paused
		
		// L1 available
		std = session.find(StudentTable.class, 1);
		System.out.println(std);
		
		session.clear();// Remove all objects in L1 cache
		
		System.in.read();//Thread is paused
		
		// Removed from L2 Cache
		factory.getCache().evictEntityData(StudentTable.class, 1);
		System.out.println("Removed from L2 cache...");
		
		System.in.read();//Thread is paused
		
		//check in L1 not there, Check in L2 not there
		//hit db ---> select query is generated
		std = session.find(StudentTable.class, 1);
		System.out.println(std);
		
	}
}
