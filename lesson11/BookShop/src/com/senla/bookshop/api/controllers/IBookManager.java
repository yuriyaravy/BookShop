package com.senla.bookshop.api.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.senla.bookshop.entities.Book;

public interface IBookManager {
	
	void getAnnotationBook() throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ParseException, SQLException;

	List<Book> getBookByName() throws ClassNotFoundException;

	List<Book> getBookByPrice();

	List<Book> getBookByStatus();

	List<Book> getBookByYearOfPublic();

	List<Book> getBookByDate();

	List<Book> getBooks();

	Book getBookById(int id);

	List<Book> sortOldBooks();

	void addBook(Book book);

	
	
}
