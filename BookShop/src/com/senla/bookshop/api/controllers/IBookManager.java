package com.senla.bookshop.api.controllers;

import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.entities.Book;

public interface IBookManager {
	
	Book getBookById(int id);

	List<Book> getBook(Comparator<Book> comparator);

	void saveBookToCSV(int id);

	List<Book> getBooks();

	void readBookFromCSV() throws ParseException;

	void serializationForBooks();

	void fillUpBookStorage();

}
