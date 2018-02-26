package com.senla.bookshop.api.facade;

import java.sql.SQLException;
import java.util.List;

import com.senla.bookshop.entiti.Book;
import com.senla.bookshop.entiti.Order;
import com.senla.bookshop.entiti.Request;

public interface IFacade {

	void addRequest(Object t) throws SQLException;

	Request getAllRequest() throws Exception;

	boolean requestAnnotationFromCSV() throws Exception;

	boolean booksAnnotationFromCSV() throws Exception;

	Book getBookById(int id) throws Exception;

	List<Book> sortBookByDate() throws Exception;

	List<Book> sortBookByName() throws Exception;

	List<Book> sortBookByPrice() throws Exception;

	List<Book> sortBookByStatus() throws Exception;

	List<Book> sortBookByYearOfPublic() throws Exception;

	List<Book> getBooks() throws Exception;

	List<Book> sortOldBook() throws Exception;

	List<Order> getOrders() throws Exception;

	List<Request> getRequests() throws Exception;

	List<String> sortRequestByName() throws Exception;

	List<Double> sortRequestAmounte() throws Exception;

	List<Order> sortOrderByDateOfDeliver() throws Exception;

	List<Order> sortOrderByStatus() throws Exception;

	int getCountOfOrder() throws Exception;

	double getProfitForAllOrders() throws Exception;

	void orderCompleate(int id) throws SQLException;

	void allOrderCompleate() throws SQLException;

	Order getOrderById(int id) throws Exception;

	boolean deleteBookToOrder(int id);

	boolean cancelOrder(int id);

	List<Double> sortOrderByPrice() throws Exception;

	void getProfitByPeriodOfTime(int day) throws Exception;

	boolean addBookToOrder(List<Book> book);

	List<Request> readObjectFromCSV() throws Exception;

	List<Book> getAllBooks() throws Exception;

	boolean addBook(Book book) throws Exception;

	boolean orderAnnotationToCSV() throws Exception;

	boolean orderAnnotationFromCSV() throws Exception;

	void requestAnnotationToCSV() throws Exception;
	
	

	
}