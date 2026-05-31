package in.pw.ioi;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.pw.ioi.entity.StudentTable;

public class TestAppNoWait {

	public static void main(String[] args) throws IOException {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		// Check in L1 not there, check in L2 not there
		// hit db ------> select query is generated
		StudentTable std = session.find(StudentTable.class, 1);
		System.out.println(std);
		
		System.in.read(); // Thread is paused
		
		// Get it from L1 cache
		std = session.find(StudentTable.class, 1);
		System.out.println(std);
		
		// Remove from L1 cache
		session.evict(std);
		System.out.println("Object is cleared from L1Cache");
		
		System.in.read(); // Thread is paused
		
		// L1 -----> not there, L2 -------> available -----> Give it to L1 ---> L1 to application
		std = session.find(StudentTable.class, 1);
		System.out.println(std);
		
		System.in.read(); // Thread is paused
		
		//L1 ----> available
		std = session.find(StudentTable.class, 1);
		System.out.println(std);
		
		session.clear(); // Remove all objects from L1 cache
		
		System.in.read(); // Thread is paused

		// Remove from L2 cache
		factory.getCache().evictEntityData(StudentTable.class, 1);
		System.out.println("Removed from L2 cache...");
		
		System.in.read(); // Thread is paused

		// Check in L1 not there, check in L2 not there
		// hit db ------> select query is generated
		std = session.find(StudentTable.class, 1);
		System.out.println(std);
	}
}
