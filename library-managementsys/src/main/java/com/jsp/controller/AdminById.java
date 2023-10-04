package com.jsp.controller;

import com.jsp.service.Service;

public class AdminById {
	public static void main(String[] args) {
		Service service =new Service();
		service.getAdminById(1);
	}

}
