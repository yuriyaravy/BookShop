package com.senla.bookshop.dao.api;

import java.util.List;

import com.senla.bookshop.entities.Book;

public interface IBookDao extends IDataBaseDao<Book> {

	List<Book> getBookByName();

	List<Book> getBookByDate();

	List<Book> getBookByYearOfPublic();

	List<Book> getBookByStatus();

	List<Book> getBookByPrice();

	List<Book> getBooks();

	List<Book> getOldBook();
	

}
