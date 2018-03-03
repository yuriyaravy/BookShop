package com.senla.bookshop.facade;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.bookshop.api.controllers.IBookManager;
import com.senla.bookshop.api.controllers.IOrderManager;
import com.senla.bookshop.api.controllers.IRequestManager;
import com.senla.bookshop.api.facade.IFacade;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entiti.Book;
import com.senla.bookshop.entiti.Order;
import com.senla.bookshop.entiti.Request;

public class Facade implements IFacade{
	
	final static Logger logger = Logger.getLogger(Facade.class);
	
	private IRequestManager requestManager = (IRequestManager) DependencyIngection.getInctance().getClassInstance(IRequestManager.class);
	private IBookManager bookManager = (IBookManager) DependencyIngection.getInctance().getClassInstance(IBookManager.class);
	private IOrderManager orderManager = (IOrderManager) DependencyIngection.getInctance().getClassInstance(IOrderManager.class);
	
	private static Facade facade;
	
	public static Facade getInstance() {
		if (facade == null) {
			facade = new Facade();
		}
		return facade;
	}
	@Override
	public void addRequest(Request request) throws SQLException{
		try {
			requestManager.addRequest( request);
		} catch (Exception e) {
			logger.error(e);
		}
	}
	@Override
	public Request getAllRequest() throws Exception{
		try {
			return	(Request) requestManager.getAllBookRequestByName();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
	@Override
	public Book getBookById(int id) throws Exception{
		Book book = null;
		try {
			book = bookManager.getBookById(id);
		} catch (Exception e) {
			logger.error(e);
		}
		return book;
	}
	@Override
	public double getProfitForAllOrders() throws Exception{
		double profit = 0;
		try {
			profit = orderManager.getProfitForAllOrders();
		} catch (Exception e) {
			logger.error(e);
		}
		return profit;
	}
	@Override
	public void orderCompleate(int id){
		try {
			orderManager.orderCompleate(id);
		} catch (Exception e) {
			logger.error(e);
		}
	}
	@Override
	public void allOrderCompleate(){
		try {
			orderManager.allOrderCompleate();
		} catch (Exception e) {
			logger.error(e);
		}
		
	}
	@Override
	public void getProfitByPeriodOfTime(int day)throws Exception {
		try {
			orderManager.getProfitByPeriodOfTime(day);
		} catch (Exception e) {
			logger.error(e);
		}
		
	}
	@Override
	public Order getOrderById(int id) throws Exception {
		Order order = null;
		try {
			order = orderManager.getOrderById(id);
		} catch (Exception e) {
			logger.error(e);
		}
		return order;
	}
	@Override
	public boolean addBookToOrder(List<Book> book) {
		try {
			orderManager.addBookToOrder((Book) book);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
	@Override
	public boolean deleteBookToOrder(Order order) {
		try {
			orderManager.deleteOrder(order);
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
	public int getCountOfOrder() throws Exception {
		int orders = 0;
		try {
			orders = orderManager.getCountOfOrder();
		} catch (Exception e) {
			logger.error(e);
		}
		return orders;
	}
	@Override
	public List<Object[]> sortRequestByName() throws Exception{
		try {
			return requestManager.getAllBookRequestByName();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public Double sortRequestAmounte() throws Exception{
		try {
			return requestManager.getAllBookRequestByAmount();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public List<Order> sortOrderByDateOfDeliver() throws Exception{
		try {
			return orderManager.getOrderByDateOfDelivered();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public Double sortOrderByPrice() throws Exception{
		try {
			return orderManager.getOrderByPrice();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public List<Order> sortOrderByStatus() throws Exception{
		try {
			return orderManager.getOrderByStatus();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public List<Book> sortBookByDate() throws Exception{
		try {
			return bookManager.getBookByDate();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public List<Book> sortBookByName() throws Exception{
		try {
			return bookManager.getBookByName();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Book> sortBookByPrice() throws Exception{
		try {
			return bookManager.getBookByPrice();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public List<Book> sortBookByStatus() throws Exception{
		try {
			return bookManager.getBookByStatus();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public List<Book> sortBookByYearOfPublic() throws Exception{
		try {
			return bookManager.getBookByYearOfPublic();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	@Override
	public List<Book> sortOldBook() throws Exception{
		try {
			return bookManager.sortOldBooks();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	@Override
	public List<Book> getBooks() throws Exception{
		try {
			return bookManager.getBookByName();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public List<Book> getAllBooks() throws Exception{
		try {
			return bookManager.getBookByName();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public List<Order> getOrders() throws Exception{
		try {
			return orderManager.getOrders();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public List<Request> getRequests() throws Exception{
		try {
			return requestManager.getRequest();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public List<Request> readObjectFromCSV() throws Exception{
		try {
			return requestManager.getRequest();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	@Override
	public boolean booksAnnotationFromCSV() throws Exception{
		try {
			bookManager.getAnnotationBook();
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
	
	@Override
	public boolean orderAnnotationFromCSV() throws Exception{
		try {
			orderManager.getAnnotationOrder();
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
	
	@Override
	public boolean orderAnnotationToCSV() throws Exception{
		try{
			orderManager.saveAnnotationOrder();
		return true;
		}catch(Exception e){
			logger.error(e);
			return false;
		}
	}
	
	@Override
	public boolean requestAnnotationFromCSV() throws Exception{
		try {
				requestManager.getAnnotationRequest();
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
	@Override
	public void requestAnnotationToCSV() throws Exception{
		try {
				requestManager.saveAnnotationRequest();
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	@Override
	public boolean addBook(Book book) throws Exception{
		try{
			bookManager.addBook(book);
		return true;
		}catch(Exception e){
			logger.error(e);
			return false;
		}
	}
}
