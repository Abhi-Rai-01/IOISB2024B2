package com.app.hiber.youtubeHibernateApp.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import com.app.hiber.youtubeHibernateApp.entities.Student;
import com.app.hiber.youtubeHibernateApp.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class StudentService {
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); 
	
	// save
	public void saveStudent(Student student) {
		try(Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.persist(student);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// get student by Id
	public Student getById(Integer studentId) {
		try(Session session = sessionFactory.openSession()) {
			Student student = session.getReference(Student.class, studentId);
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Update student
	public Student updateStudent(Integer studentId, Student student) {
		try(Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Student oldStudent = session.getReference(Student.class, studentId);
			
			if(oldStudent != null) {
				oldStudent.setName(oldStudent.getName());
				oldStudent.setFatherName(oldStudent.getFatherName());
//				..... update more information
			
				oldStudent = session.merge(oldStudent);
				tx.commit();
				
				return oldStudent;
			}
		}
		return null;
	}
	
	// Delete Student
	public void deleteStudent(Integer studentId) {
		try(Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			
			Student student = session.getReference(Student.class, studentId);
			if(student != null) {
				session.remove(student);
			}
			
			tx.commit();
		}
	}
	
	// HQL[JPA]
	//database independent
	
	// get all students using hql
	public List<Student> getAllStudentsHql() {
		try(Session session = sessionFactory.openSession()) {
			String getHql = "FROM Student";
			Query<Student> query = session.createQuery(getHql, Student.class);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//get student by name
	public Student getStudentByNameHql(String name) {
		try(Session session = sessionFactory.openSession()) {
			String getByNameHql = "FROM Student WHERE studentName = :stdName";
			Query<Student> query = session.createQuery(getByNameHql, Student.class);
			query.setParameter("stdName", name);
			return query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// criteria api:
	// get all students of same college
	
	public List<Student> getStudentsByCollegeCriteria(String college) {
		try(Session session = sessionFactory.openSession()) {
			
			HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
			
			Root<Student> root = query.from(Student.class);
			query.select(root).where(criteriaBuilder.equal(root.get("studentCollege"), college));
			
			Query<Student> query2 = session.createQuery(query);
			return query2.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Student> getStudentsWithPagination(int pageNo, int pageSize) {
		try(Session session = sessionFactory.openSession()) {
			String pagiQuery = "FROM Student";
			Query<Student> query = session.createQuery(pagiQuery, Student.class);
			
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
			
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
