package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javax.persistence.TypedQuery;

import com.jsp.dto.AdminDto;



public class AdminDao {
	
	AdminDto adminDto=new AdminDto();
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("deva");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public AdminDto insertData(AdminDto adminDto) {
        entityTransaction.begin();
		entityManager.persist(adminDto);
		entityTransaction.commit();
		return adminDto;
	}
	
	public AdminDto deleteData(int id) {
       AdminDto adminDto=entityManager.find(AdminDto.class, id);
		
		entityTransaction.begin();
		entityManager.remove(adminDto);
		entityTransaction.commit();
		
		return adminDto;
	}
	
	public AdminDto updateData(int id,String password) {
		 AdminDto adminDto=entityManager.find(AdminDto.class, id);
		adminDto.setPassword(password);
		entityTransaction.begin();
		entityManager.merge(adminDto);
		entityTransaction.commit();
		return adminDto;
	}
	public AdminDto getAdminById(int id) {

		AdminDto adminDto = entityManager.find(AdminDto.class, id);
		System.out.print(adminDto.getId());
		System.out.print(adminDto.getUsername());
		System.out.println(adminDto.getPassword());
	
		return adminDto;

	}

		
		public List<AdminDto> getAllRes(){
			String sql="SELECT r FROM AdminDto r";
			TypedQuery<AdminDto> query=entityManager.createQuery(sql,AdminDto.class);
			List<AdminDto> admindtoall=query.getResultList();
			for (AdminDto adminDto : admindtoall) {
				System.out.println(adminDto.getId());
				System.out.println(adminDto.getUsername());
				System.out.println(adminDto.getPassword());
				System.out.println("================");
				
			}
			return admindtoall;
			
		}
	

}


