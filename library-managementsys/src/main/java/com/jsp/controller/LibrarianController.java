package com.jsp.controller;

import com.jsp.dto.LibrarianDto;
import com.jsp.service.LibraryService;

public class LibrarianController {
	public static void main(String[] args) {
		LibraryService libraryService=new LibraryService();
		LibrarianDto librarianDto=new LibrarianDto();
		librarianDto.setName("jadu");
		librarianDto.setPassword("jadu");
		librarianDto.setStatus("authorized");
		libraryService.insertLibrarian(librarianDto);
	}

}
