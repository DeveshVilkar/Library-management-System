package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jsp.dto.Student;


public class StudentDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("deva");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public Student insertData(Student student) {
        entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}
	
	public Student deleteData(int id) {
		Student student=entityManager.find(Student.class, id);
		
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		
		return student;
	}
	
	public Student updateData(int id,Long ph_no) {
		Student student =entityManager.find(Student.class, id);
		student.setPh_no(ph_no);
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}
	public Student getStudentById(int id) {

		Student student = entityManager.find(Student.class, id);
		System.out.print(student.getStudent_id());
		System.out.print(student.getName());
		System.out.println(student.getPh_no());
	
		return student;

	}
	       public List<Student> getAllRes(){
			String sql="SELECT r FROM Student r";
			TypedQuery<Student> query=entityManager.createQuery(sql,Student.class);
			List<Student> studentall=query.getResultList();
			for (Student student : studentall) {
				System.out.println(student.getStudent_id());
				System.out.println(student.getName());
				System.out.println(student.getPh_no());
			}
			return studentall;
			
		}
	


}
