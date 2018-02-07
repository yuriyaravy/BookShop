package com.senla.bookshop.api.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.entities.Book;

public interface IBookManager {
	
	Book getBookById(int id);

	List<Book> getBook(Comparator<Book> comparator);

	List<Book> getBooks();

	void readBookFromCSV() throws ParseException;

	void serializationForBooks();

	void fillUpBookStorage();

	void saveBookToCSV();

	void getAnnotationBook() throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ParseException;

}
