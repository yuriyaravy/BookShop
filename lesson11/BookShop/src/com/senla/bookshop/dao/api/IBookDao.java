package com.senla.bookshop.dao.api;

import java.util.List;

import com.mysql.jdbc.Connection;
import com.senla.bookshop.entities.Book;

public interface IBookDao extends IDataBaseDao<Book> {

	List<Book> getBookByName(Connection connection);

	List<Book> getBookByDate(Connection connection);

	List<Book> getBookByYearOfPublic(Connection connection);

	List<Book> getBookByStatus(Connection connection);

	List<Book> getBookByPrice(Connection connection);

	List<Book> getBooks(Connection connection);

	List<Book> getOldBook(Connection connection);
	

}
