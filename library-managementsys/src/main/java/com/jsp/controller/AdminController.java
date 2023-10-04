package com.jsp.controller;
import com.jsp.dto.AdminDto;
import com.jsp.service.Service;

public class AdminController {
	public static void main(String[] args) {
		Service service=new Service();
		AdminDto adminDto=new AdminDto();
		adminDto.setUsername("dev");
		adminDto.setPassword("devv");
		service.insertData(adminDto);
	}

}
