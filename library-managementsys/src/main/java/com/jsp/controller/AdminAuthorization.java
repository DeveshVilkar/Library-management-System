package com.jsp.controller;

import com.jsp.service.Service;

public class AdminAuthorization {
	public static void main(String[] args) {
		Service service=new Service();
		boolean res = service.approveLibrarian(5, 1);
		System.out.println(res);
	}

}
