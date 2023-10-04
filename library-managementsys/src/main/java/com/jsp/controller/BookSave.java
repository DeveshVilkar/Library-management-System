package com.jsp.controller;

import com.jsp.dto.Book;
import com.jsp.service.BookService;

public class BookSave {
	public static void main(String[] args) {
		BookService bookService = new BookService();
		Book book = new Book();
		book.setBook_name("sudha murty");
		book.setStatus("available");
		bookService.insertData(book);
	}

}
