package com.jsp.service;


import java.util.List;

import com.jsp.dao.AdminDao;
import com.jsp.dao.LibrarianDao;
import com.jsp.dto.AdminDto;
import com.jsp.dto.LibrarianDto;

public class Service {
	AdminDao adminDao=new AdminDao();
	LibrarianDao librarianDao=new LibrarianDao();
	
	public AdminDto insertData(AdminDto adminDto) {
		return adminDao.insertData(adminDto);
		
	}
	public AdminDto deleteData(int id) {
		return adminDao.deleteData(id);
	}
	
	public AdminDto updateData(int id,String password) {
	       return adminDao.updateData(id, password);
	}
	
	public AdminDto getAdminById(int id) {
		return adminDao.getAdminById(id);
	}
	
	public List<AdminDto> getAllRes(){
		return adminDao.getAllRes();
	}
	
	public boolean login(String username,String password) {
		  List<AdminDto> user=adminDao.getAllRes();
		for (AdminDto adminuser : user) {
			if (adminuser.getUsername().equals(username) && adminuser.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean approveLibrarian(int lid,int adminid) {
		LibrarianDto librarianDto=librarianDao.getLibrarianById(lid);
		AdminDto adminDto=adminDao.getAdminById(adminid);
		if (librarianDto!=null && adminDto!=null) {
			librarianDto.setStatus("authorized");
			librarianDto.setAdminDto(adminDto);
			return librarianDao.approve(librarianDto);
			
		}
		return false;
		
	}
	

}
