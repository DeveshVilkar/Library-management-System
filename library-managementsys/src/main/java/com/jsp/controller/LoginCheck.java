package com.jsp.controller;

import com.jsp.service.Service;

public class LoginCheck {
	public static void main(String[] args) {
		Service service=new Service();
		boolean login_result=service.login("devil", "devesh11");
		if (login_result==true) {
			System.out.println("login successfully");
		}else {
			System.out.println("login failed");
		}
	}

}
