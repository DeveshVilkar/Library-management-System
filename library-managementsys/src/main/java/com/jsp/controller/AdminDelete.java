package com.jsp.controller;

import com.jsp.service.Service;

public class AdminDelete {
	public static void main(String[] args) {
		Service service =new Service();
		service.deleteData(2);
	}

}
