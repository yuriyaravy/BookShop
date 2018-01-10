package backend.src.com.senla.bookshop.facade;

import java.util.ArrayList;
import java.util.Comparator;

import org.apache.log4j.Logger;

import backend.src.com.senla.bookshop.api.controllers.IBookManager;
import backend.src.com.senla.bookshop.api.controllers.IOrderManager;
import backend.src.com.senla.bookshop.api.controllers.IRequestManager;
import backend.src.com.senla.bookshop.api.facade.IFacade;
import backend.src.com.senla.bookshop.controllers.BookManager;
import backend.src.com.senla.bookshop.controllers.OrderManager;
import backend.src.com.senla.bookshop.controllers.RequestManager;
import backend.src.com.senla.bookshop.entities.Book;
import backend.src.com.senla.bookshop.entities.Order;
import backend.src.com.senla.bookshop.entities.Request;

public class Facade implements IFacade{
	
	final static Logger logger = Logger.getLogger(Facade.class);
	
	private IRequestManager requestManager = new RequestManager();
	private IBookManager bookManager = new BookManager();
	private IOrderManager orderManager = new OrderManager();
	
	private static Facade facade;
	
	private Facade(){
		
	}
	
	public static Facade getInstance() {
		if (facade == null) {
			facade = new Facade();
		}
		return facade;
	}
	
	@Override
	public void addRequest(int id){
		requestManager.addRequest(id);
	}

	@Override
	public Request getRequestById(int id) {
		return	requestManager.getRequestById(id);
	}

	@Override
	public Book getBookById(int id) {
		Book book = bookManager.getBookById(id);
		return book;
	}

	@Override
	public double getProfitForAllOrders() {
		double profit = orderManager.getProfitForAllOrders();
		return profit;
	}

	@Override
	public void orderCompleate(int id) {
		orderManager.orderCompleate(id);
	}

	@Override
	public void allOrderCompleate() {
		orderManager.allOrderCompleate();
	}

	@Override
	public void getProfitByPeriodOfTime(int day) {
		orderManager.getProfitByPeriodOfTime(day);
		
	}

	@Override
	public double getProfitForOneOrder(Order order) {
		double profit = orderManager.getProfitForAllOrders();
		return profit;
	}

	@Override
	public Order getOrderById(int id) {
		Order order = orderManager.getOrderById(id);
		return order;
	}

	@Override
	public void addBookToOrder(int[] bookId) {
		orderManager.addBookToOrder(bookId);
	}

	@Override
	public void deleteBookToOrder(int id) {
		orderManager.deleteBookToOrder(id);
		
	}

	@Override
	public void cancelOrder(int id) {
		orderManager.cancelOrder(id);
		
	}

	@Override
	public int getCountOfOrder() {
		int orders = orderManager.getCountOfOrder();
		return orders;
	}

	
}
