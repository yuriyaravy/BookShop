package com.senla.bookshop.api.dao;

import java.util.List;

import com.mysql.jdbc.Connection;
import com.senla.bookshop.entities.Book;

public interface IBookDao extends IGenericDao<Book> {

	List<Book> getBookByName(Connection connection);

	List<Book> getBookByDate(Connection connection);

	List<Book> getBookByYearOfPublic(Connection connection);

	List<Book> getBookByStatus(Connection connection);

	List<Book> getBookByPrice(Connection connection);

	List<Book> getBooks(Connection connection);

	List<Book> getOldBook(Connection connection) throws Exception;
	

}
