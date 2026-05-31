package com.app.hiber.youtubeHibernateApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.hiber.youtubeHibernateApp.entities.Certificate;
import com.app.hiber.youtubeHibernateApp.entities.Student;
import com.app.hiber.youtubeHibernateApp.util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("We are learning hibernate [ORM Tool]");
        
        // student create
        // save: hibernate
        
        // create a student object
        Student student = new Student();
        
        student.setName("Amit sahu");
        student.setCollege("IIT Dholakpur");
        student.setPhone("9438364822");
        student.setFatherName("Ankul sahu");
        student.setActive(true);
        student.setAbout("The student is in his 3nd year");
        
        Certificate certificate = new Certificate();
        certificate.setTitle("Java Certification");
        certificate.setAbout("This is java certification");
        certificate.setLink("java.certification");
        certificate.setStudent(student);
        
        Certificate certificate1 = new Certificate();
        certificate1.setTitle("GO Certification");
        certificate1.setAbout("This is GO certification");
        certificate1.setLink("go.certification");
        certificate1.setStudent(student);
        
        student.getCertificates().add(certificate);
        student.getCertificates().add(certificate1);
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        System.out.println(sessionFactory);
        
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try {
			tx = session.beginTransaction();
			
			session.persist(student);
			
			tx.commit();
			
			System.out.println("Student data saved successfully");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			
			e.printStackTrace();
		} finally {
			session.close();
		}
    }
}
