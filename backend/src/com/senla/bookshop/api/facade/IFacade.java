package backend.src.com.senla.bookshop.api.facade;

import java.util.ArrayList;

import backend.src.com.senla.bookshop.entities.Book;
import backend.src.com.senla.bookshop.entities.Order;
import backend.src.com.senla.bookshop.entities.Request;

public interface IFacade {
	
	public void addRequest(int id);
	
	public Request getRequestById(int id);
	
	public Book getBookById(int id);
	
	public double getProfitForAllOrders();
	
	public void orderCompleate(int id);
	
	public  void allOrderCompleate();
	
	public void getProfitByPeriodOfTime(int day);
	
	public double getProfitForOneOrder(Order order);
	
	public Order getOrderById(int id);
	
	public void addBookToOrder(int[] bookId);
	
	public void deleteBookToOrder(int id);
	
	public void cancelOrder(int id);
	
	public int getCountOfOrder();

	public ArrayList<Request> sortRequestAmounte();

	public ArrayList<Request> sortRequestByName();

	ArrayList<Order> sortOrderByStatus();

	ArrayList<Order> sortOrderByPrice();

	ArrayList<Order> sortOrderByDateOfCompleate();

	ArrayList<Order> sortOrderByDate();

	ArrayList<Order> sortOrderByDateOfDeliver();

	ArrayList<Book> sortBookByDate();

	ArrayList<Book> sortBookByName();

	ArrayList<Book> sortBookByPrice();

	ArrayList<Book> sortBookByStatus();

	ArrayList<Book> sortBookByYearOfPublic();

	ArrayList<Order> sortOrderByCompleate();

	void saveBookToCSV(int id);

	void saveOrderToCSV(int id);

	void saveRequestToCSV(int id);

	public ArrayList<String> readRequestFromCSV();

	public ArrayList<String> readOrderFromCSV();

	public ArrayList<String> readBookFromCSV();

	ArrayList<Book> getBooks();

	ArrayList<Request> getRequests();

	ArrayList<Order> getOrders();

	void cloneOrder(Order order);

	void serializationForBook();

	void serializationForOrder();

	void serializationForRequest();
	
	
}
