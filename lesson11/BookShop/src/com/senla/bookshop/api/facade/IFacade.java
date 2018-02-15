package com.senla.bookshop.api.facade;

import java.sql.SQLException;
import java.util.List;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;

public interface IFacade {

	void addRequest(Object t) throws SQLException;

	Request getAllRequest();

	boolean OrderAnnotationFromCSV();

	boolean requestAnnotationFromCSV();

	boolean booksAnnotationFromCSV();

	Book getBookById(int id);

	List<Book> sortBookByDate();

	List<Book> sortBookByName();

	List<Book> sortBookByPrice();

	List<Book> sortBookByStatus();

	List<Book> sortBookByYearOfPublic();

	List<Book> getBooks();

	List<Book> sortOldBook();

	List<Order> getOrders();

	List<Request> getRequests();

	List<String> sortRequestByName();

	List<Double> sortRequestAmounte();

	List<Order> sortOrderByDateOfDeliver();

	List<Order> sortOrderByStatus();

	int getCountOfOrder();

	double getProfitForAllOrders();

	void orderCompleate(int id) throws SQLException;

	void allOrderCompleate() throws SQLException;

	Order getOrderById(int id);

	boolean deleteBookToOrder(int id);

	boolean cancelOrder(int id);

	List<Double> sortOrderByPrice();

	void getProfitByPeriodOfTime(int day);

	boolean addBookToOrder(List<Book> book);

	List<Request> readObjectFromCSV();

	double getProfitForOneOrder();

	List<Book> getAllBooks();

	boolean addBook(Book book);
	
	

	
}
