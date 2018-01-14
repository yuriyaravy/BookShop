package com.senla.bookshop.api.storages;

import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.entities.Book;

public interface IBookStorage {
	
	void addBook(Book book);
	
	List<Book> getBooks();

	List<Book> getSortBook(Comparator<Book> comparator);

	void setBooks(List<Book> books);

	void fillUpBookStorage(String key);

	Book getBookById(int id);


}
