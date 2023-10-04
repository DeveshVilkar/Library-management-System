package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jsp.dto.LibrarianDto;

public class LibrarianDao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("deva");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public LibrarianDto insertLibrarian(LibrarianDto librarianDto) {
		entityTransaction.begin();
		entityManager.persist(librarianDto);
		entityTransaction.commit();
		return librarianDto;
	}
	public LibrarianDto deleteLibrarian(int id) {
		LibrarianDto librarianDto=entityManager.find(LibrarianDto.class, id);
		entityTransaction.begin();
		entityManager.remove(librarianDto);
		entityTransaction.commit();
		return librarianDto;
	}
	public LibrarianDto updateLibrarian(int id,String password) {
		LibrarianDto librarianDto=entityManager.find(LibrarianDto.class, id);
		librarianDto.setPassword(password);
		entityTransaction.begin();
		entityManager.merge(librarianDto);
		entityTransaction.commit();
		
		return librarianDto;
	}
	public LibrarianDto getLibrarianById(int id) {

		LibrarianDto librarianDto = entityManager.find(LibrarianDto.class, id);
		System.out.println(librarianDto.getId());
		System.out.println(librarianDto.getName());
		System.out.println(librarianDto.getStatus());
		return librarianDto;

	}
	
	public List<LibrarianDto> getAllres(){
		String sql="SELECT r FROM LibrarianDto r";
		TypedQuery<LibrarianDto> query=entityManager.createQuery(sql,LibrarianDto.class);
		List<LibrarianDto> librarianall=query.getResultList();
		for (LibrarianDto librarianDto : librarianall) {
			System.out.println(librarianDto.getId());
			System.out.println(librarianDto.getName());
			System.out.println(librarianDto.getPassword());
			System.out.println(librarianDto.getStatus());
			System.out.println("==============");
			
		}
		
		return librarianall;
	}
	
	public boolean approve(LibrarianDto librarianDto) {
		entityTransaction.begin();
		entityManager.merge(librarianDto);
		entityTransaction.commit();
		return true;
	}

}
