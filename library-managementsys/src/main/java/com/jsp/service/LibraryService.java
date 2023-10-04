package com.jsp.service;

import java.util.List;

import com.jsp.dao.BookDao;
import com.jsp.dao.LibrarianDao;
import com.jsp.dao.StudentDao;
import com.jsp.dto.Book;
import com.jsp.dto.LibrarianDto;
import com.jsp.dto.Student;

public class LibraryService {
	LibrarianDao librarianDao=new LibrarianDao();
	BookDao bookDao=new BookDao();
	StudentDao studentDao = new StudentDao();

	
	public LibrarianDto insertLibrarian(LibrarianDto librariandto) {
		if (librariandto.getStatus().equalsIgnoreCase("authorized")) {
			librariandto.setStatus("unauthorized");
			}
		return librarianDao.insertLibrarian(librariandto);
	}
	
	public LibrarianDto deleteLibrarian(int id) {
		return librarianDao.deleteLibrarian(id);
	}
	
	public LibrarianDto updateLibrarian(int id,String password) {
		return  librarianDao.updateLibrarian(id, password);
		
	}
	public LibrarianDto getLibrarianById(int id) {
		return librarianDao.getLibrarianById(id);
	}
	
	public List<LibrarianDto> getAllres(){
		return librarianDao.getAllres();
	
	}
	
	public Boolean addBook(Book book) {
		BookDao bookDao = new BookDao();
		bookDao.insertData(book);
		return true;
	}

	public Boolean removeBookById(int bookid) {
		BookDao bookDao = new BookDao();
		bookDao.deleteData(bookid);
		return true;
	}

	public boolean issueBookById(int bookid, int libid, int studid) {
		Book book = bookDao.getBookById(bookid);
		Student student = studentDao.getStudentById(studid);
		LibrarianDto librarian = librarianDao.getLibrarianById(libid);
		if (librarian != null && book != null && student != null) {
			if (book.getStatus().equals("available")) {
				book.setStatus("Issued");
				book.setStudent(student);
				book.setLibrarian(librarian);
				return bookDao.issue(book);
			}else {
				System.out.println("The book is already issued.");
			}
		}
		return false;
	}

	public boolean returnBookById(int bookid) {
		Book book = bookDao.getBookById(bookid);
		if (book != null && book.getStatus().equals("Issued")) {
			Student student = book.getStudent();
			LibrarianDto librarian = book.getLibrarian();

			if (student != null && librarian != null) {
				book.setStatus("Available");
				book.setStudent(null);
				book.setLibrarian(null);
				return bookDao.returnBook(book);
			}
		}
		return false;
	}

	

}
