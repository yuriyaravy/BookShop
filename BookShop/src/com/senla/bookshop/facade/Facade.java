package com.senla.bookshop.facade;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.bookshop.api.controllers.IBookManager;
import com.senla.bookshop.api.controllers.IOrderManager;
import com.senla.bookshop.api.controllers.IRequestManager;
import com.senla.bookshop.api.facade.IFacade;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.managers.BookManager;
import com.senla.bookshop.managers.OrderManager;
import com.senla.bookshop.managers.RequestManager;
import com.senla.bookshop.storage.OrderStorage;
import com.senla.bookshop.utils.comparators.book.ComparatorBookByDate;
import com.senla.bookshop.utils.comparators.book.ComparatorBookByName;
import com.senla.bookshop.utils.comparators.book.ComparatorBookByPrice;
import com.senla.bookshop.utils.comparators.book.ComparatorBookByStatus;
import com.senla.bookshop.utils.comparators.book.ComparatorBookByYearOfPublic;
import com.senla.bookshop.utils.comparators.order.ComparatorDateOfDeliver;
import com.senla.bookshop.utils.comparators.order.ComparatorOrderByDate;
import com.senla.bookshop.utils.comparators.order.ComparatorOrderByPrice;
import com.senla.bookshop.utils.comparators.order.ComparatorOrderByStatus;
import com.senla.bookshop.utils.comparators.order.ComparatorOrderBydateOfCompleate;
import com.senla.bookshop.utils.comparators.request.ComparatorForRequestByAmount;
import com.senla.bookshop.utils.comparators.request.ComparatorRequestByName;

public class Facade implements IFacade{
	
	final static Logger logger = Logger.getLogger(Facade.class);
	
	private IRequestManager requestManager = (IRequestManager) DependencyIngection.getInctance().getClassInstance(IRequestManager.class);
	private IBookManager bookManager = (IBookManager) DependencyIngection.getInctance().getClassInstance(IBookManager.class);
	private IOrderManager orderManager = (IOrderManager) DependencyIngection.getInctance().getClassInstance(IOrderManager.class);
	
	private static Facade facade;
	
	public Facade(){
		
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
	public boolean addBookToOrder(List<Book> book) {
		try {
			orderManager.addBookToOrder(book);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
	@Override
	public boolean deleteBookToOrder(int id) {
		try {
			orderManager.deleteBookToOrder(id);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
		
	}
	@Override
	public boolean cancelOrder(int id) {
		try {
			orderManager.cancelOrder(id);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
		
	}
	@Override
	public int getCountOfOrder() {
		int orders = orderManager.getCountOfOrder();
		return orders;
	}
	@Override
	public List<Request> sortRequestByName(){
		return requestManager.getRequests(new ComparatorRequestByName());
	}
	@Override
	public List<Request> sortRequestAmounte(){
		return requestManager.getRequests(new ComparatorForRequestByAmount());
	}
	@Override
	public List<Order> sortOrderByDateOfDeliver(){
		return orderManager.getOrders(new ComparatorDateOfDeliver());
	}
	@Override
	public List<Order> sortOrderByDate(){
		return orderManager.getOrders(new ComparatorOrderByDate());
	}
	@Override
	public List<Order> sortOrderByDateOfCompleate(){
		return orderManager.getOrders(new ComparatorOrderBydateOfCompleate());
	}
	@Override
	public List<Order> sortOrderByPrice(){
		return orderManager.getOrders(new ComparatorOrderByPrice());
	}
	@Override
	public List<Order> sortOrderByStatus(){
		return orderManager.getOrders(new ComparatorOrderByStatus());
	}
	@Override
	public List<Order> sortOrderByCompleate(){
		return orderManager.getOrders(new ComparatorOrderBydateOfCompleate());
	}
	@Override
	public List<Book> sortBookByDate(){
		return bookManager.getBook(new ComparatorBookByDate());
	}
	@Override
	public List<Book> sortBookByName(){
		return bookManager.getBook(new ComparatorBookByName());
	}
	@Override
	public List<Book> sortBookByPrice(){
		return bookManager.getBook(new ComparatorBookByPrice());
	}
	@Override
	public List<Book> sortBookByStatus(){
		return bookManager.getBook(new ComparatorBookByStatus());
	}
	@Override
	public List<Book> sortBookByYearOfPublic(){
		return bookManager.getBook(new ComparatorBookByYearOfPublic());
	}
	@Override
	public void saveBookToCSV(){
		bookManager.saveBookToCSV();
	}
	@Override
	public void saveOrderToCSV(){
		orderManager.saveOrderToCSV();
	}
	@Override
	public void saveRequestToCSV(){
		requestManager.saveRequestToCSV();
	}
	@Override
	public boolean readRequestFromCSV(){
		try {
			requestManager.readRequestFromCSV();
			return true;
		} catch (ParseException e) {
			logger.error(e);
			return false;
		}
	}
	@Override
	public boolean readBookFromCSV(){
		try {
			bookManager.readBookFromCSV();
			return true;
		} catch (ParseException e) {
			logger.error(e);
			return false;
		}
	}
	@Override
	public boolean readOrderFromCSV(){
		try {
			orderManager.readOrderFromCSV();
			return true;
		} catch (ParseException e) {
			logger.error(e);
			return false;
		}
	}
	@Override
	public List<Book> getBooks(){
		return bookManager.getBooks();
	}
	@Override
	public List<Order> getOrders(){
		return orderManager.getOrders();
	}
	@Override
	public List<Request> getRequests(){
		return requestManager.getRequests();
	}
	@Override
	public void serializationForBook(){
		bookManager.serializationForBooks();
	}
	@Override
	public void serializationForOrder(){
		orderManager.serializationForOrder();
	}
	@Override
	public void serializationForRequest(){
		requestManager.serializationForRequest();
	}
	@Override
	public boolean cloneOrder(Order order){
		try {
			orderManager.cloneOrder(order);
			OrderStorage.getInstance().getOrdersBooks().add(order);
			return true;
		} catch (CloneNotSupportedException e) {
			logger.error(e);
			return false;
		}
	}
	@Override
	public void fillUpStorages(){
		orderManager.fillUpOrderStorage();
		bookManager.fillUpBookStorage();
		requestManager.fillUpRequestStorage();
	}
	@Override
	public boolean booksAnnotationFromCSV(){
		try {
			bookManager.getAnnotationBook();
			return true;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IOException | ParseException e) {
			logger.error(e);
			return false;
		}
	}
	
	@Override
	public boolean OrderAnnotationFromCSV(){
		try {
			orderManager.getAnnotationOrder();
			return true;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IOException | ParseException e) {
			logger.error(e);
			return false;
		}
	}
	
	@Override
	public boolean requestAnnotationFromCSV(){
		try {
			requestManager.getAnnotationRequest();
			return true;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IOException | ParseException e) {
			logger.error(e);
			return false;
		}
	}
}
