package com.jsp.controller;

import com.jsp.service.LibraryService;

public class IssueBook {
	public static void main(String[] args) {
		LibraryService libraryService = new LibraryService();
		boolean res = libraryService.issueBookById(1, 5, 2);
		System.out.println(res);
	}

}
