package com.jsp.controller;

import com.jsp.service.LibraryService;

public class LibrarianDelete {
	public static void main(String[] args) {
		LibraryService libraryService=new LibraryService();
		libraryService.deleteLibrarian(2);
	}

}
