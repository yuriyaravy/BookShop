package com.senla.bookshop.api.facade;

import java.sql.SQLException;
import java.util.List;

import com.senla.bookshop.entity.Book;
import com.senla.bookshop.entity.Order;
import com.senla.bookshop.entity.Request;
import com.senla.bookshop.entity.User;

public interface IFacade {

	void addRequest(Request request) throws SQLException;

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

	List<Object[]> sortRequestByName() throws Exception;

	Double sortRequestAmounte() throws Exception;

	List<Order> sortOrderByDateOfDeliver() throws Exception;

	List<Order> sortOrderByStatus() throws Exception;

	int getCountOfOrder() throws Exception;

	double getProfitForAllOrders() throws Exception;

	void orderCompleate(int id) throws SQLException;

	void allOrderCompleate() throws SQLException;

	Order getOrderById(int id) throws Exception;

	boolean deleteBookToOrder(Order order);

	boolean cancelOrder(int id);

	Double sortOrderByPrice() throws Exception;

	void getProfitByPeriodOfTime(int day) throws Exception;

	boolean addBookToOrder(List<Book> book);

	List<Request> readObjectFromCSV() throws Exception;

	boolean addBook(Book book) throws Exception;

	boolean orderAnnotationToCSV() throws Exception;

	boolean orderAnnotationFromCSV() throws Exception;

	void requestAnnotationToCSV() throws Exception;

	Request getRequestById(int id) throws Exception;

	void deleteBook(int id) throws Exception;

	void cloneOrder(int id) throws Exception;

	void deleteRequest(int id) throws Exception;

	void registration(String name, String surname, String password) throws Exception;

	void saveLog(User user, String action) throws Exception;

	User getUserByPasswordAndLogin(String login, String password) throws Exception;

}
