package backend.src.com.senla.bookshop.api.facade;

import java.util.ArrayList;
import java.util.Comparator;

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
	
	
}
