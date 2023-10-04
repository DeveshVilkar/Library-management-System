package com.jsp.controller;

import com.jsp.service.LibraryService;

public class ReturnBook {
	public static void main(String[] args) {
		LibraryService libraryService=new LibraryService();
		boolean res=libraryService.returnBookById(1);
		System.out.println(res);
	}

}
