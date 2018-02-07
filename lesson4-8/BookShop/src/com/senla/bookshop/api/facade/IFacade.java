package com.senla.bookshop.api.facade;

import java.util.List;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;

public interface IFacade {
	
	void addRequest(int id);
	
	Request getRequestById(int id);
	
	Book getBookById(int id);
	
	double getProfitForAllOrders();
	
	void orderCompleate(int id);
	
	void allOrderCompleate();
	
	void getProfitByPeriodOfTime(int day);
	
	double getProfitForOneOrder(Order order);
	
	Order getOrderById(int id);
	
	boolean deleteBookToOrder(int id);
	
	boolean cancelOrder(int id);
	
	int getCountOfOrder();

	List<Request> sortRequestAmounte();

	List<Request> sortRequestByName();

	List<Order> sortOrderByStatus();

	List<Order> sortOrderByPrice();

	List<Order> sortOrderByDateOfCompleate();

	List<Order> sortOrderByDate();

	List<Order> sortOrderByDateOfDeliver();

	List<Book> sortBookByDate();

	List<Book> sortBookByName();

	List<Book> sortBookByPrice();

	List<Book> sortBookByStatus();

	List<Book> sortBookByYearOfPublic();

	List<Order> sortOrderByCompleate();

	void saveOrderToCSV();

	void saveRequestToCSV();

	boolean readRequestFromCSV();

	boolean readOrderFromCSV();

	boolean readBookFromCSV();

	List<Book> getBooks();

	List<Request> getRequests();

	List<Order> getOrders();

	boolean cloneOrder(Order order);

	void serializationForBook();

	void serializationForOrder();

	void serializationForRequest();

	boolean addBookToOrder(List<Book> book);

	void fillUpStorages();

	void saveBookToCSV();

	boolean booksAnnotationFromCSV();

	boolean OrderAnnotationFromCSV();

	boolean requestAnnotationFromCSV();
	
	
}
