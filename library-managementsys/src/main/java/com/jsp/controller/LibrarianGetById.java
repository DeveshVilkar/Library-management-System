package com.jsp.controller;

import com.jsp.service.LibraryService;

public class LibrarianGetById {
	public static void main(String[] args) {
		LibraryService libraryService=new LibraryService();
		libraryService.getLibrarianById(2);
	}

}
