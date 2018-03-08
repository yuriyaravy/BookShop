package com.senla.bookshop.api.controllers;

import java.util.List;

import com.senla.bookshop.entity.Book;

public interface IBookManager {

	void getAnnotationBook() throws Exception;

	void addBook(Book book) throws Exception;

	Book getBookById(int id) throws Exception;

	List<Book> getBookByName() throws Exception;

	List<Book> getBookByDate() throws Exception;

	List<Book> getBookByYearOfPublic() throws Exception;

	List<Book> getBookByStatus() throws Exception;

	List<Book> getBookByPrice() throws Exception;

	List<Book> sortOldBooks() throws Exception;
	
	

	
	
}
