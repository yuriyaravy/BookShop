package com.senla.bookshop.api.dao;

import java.util.List;

import org.hibernate.Session;

import com.senla.bookshop.entiti.Book;

public interface IBookDao extends IGenericDao<Book> {

	List<Book> sortBookByName(Session session);

	List<Book> sortBookByPrice(Session session);

	List<Book> sortBookByStatus(Session session);

	List<Book> sortBookByYearOfPublic(Session session);

	List<Book> sortBookByDate(Session session);

	List<Book> getOldBook(Session session);

	

}
