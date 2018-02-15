package com.senla.bookshop.facade;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
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
	public void addRequest(Object t) throws SQLException{
		requestManager.addRequest(t);
	}
	@Override
	public Request getAllRequest() {
		return	(Request) requestManager.getAllBookRequestByName();
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
	public void orderCompleate(int id){
		try {
			orderManager.orderCompleate(id);
		} catch (SQLException e) {
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
	public void getProfitByPeriodOfTime(int day) {
		orderManager.getProfitByPeriodOfTime(day);
		
	}
	@Override
	public double getProfitForOneOrder() {
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
			orderManager.addBookToOrder((Book) book);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
	@Override
	public boolean deleteBookToOrder(int id) {
		try {
			orderManager.deleteOrder(id);
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
	public List<String> sortRequestByName(){
		return requestManager.getAllBookRequestByName();
	}
	@Override
	public List<Double> sortRequestAmounte(){
		return requestManager.getAllBookRequestByAmount();
	}
	@Override
	public List<Order> sortOrderByDateOfDeliver(){
		return orderManager.getOrderByDateOfDelivered();
	}
	@Override
	public List<Double> sortOrderByPrice(){
		return orderManager.getOrderByPrice();
	}
	@Override
	public List<Order> sortOrderByStatus(){
		return orderManager.getOrderByStatus();
	}
	@Override
	public List<Book> sortBookByDate(){
		return bookManager.getBookByDate();
	}
	@Override
	public List<Book> sortBookByName(){
		try {
			return bookManager.getBookByName();
		} catch (ClassNotFoundException e) {
			logger.error(e);
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Book> sortBookByPrice(){
		return bookManager.getBookByPrice();
	}
	@Override
	public List<Book> sortBookByStatus(){
		return bookManager.getBookByStatus();
	}
	@Override
	public List<Book> sortBookByYearOfPublic(){
		return bookManager.getBookByYearOfPublic();
	}
	
	@Override
	public List<Book> sortOldBook(){
		return bookManager.sortOldBooks();
	}
	
	@Override
	public List<Book> getBooks(){
		return bookManager.getBooks();
	}
	@Override
	public List<Book> getAllBooks(){
		return bookManager.getBooks();
	}
	@Override
	public List<Order> getOrders(){
		return orderManager.getOrders();
	}
	@Override
	public List<Request> getRequests(){
		return requestManager.getRequest();
	}
	@Override
	public List<Request> readObjectFromCSV(){
		return requestManager.getRequest();
	}
	
	@Override
	public boolean booksAnnotationFromCSV(){
		try {
			bookManager.getAnnotationBook();
			return true;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IOException | ParseException | SQLException e) {
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
				| IOException | ParseException | SQLException e) {
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
				| IOException | ParseException | SQLException e) {
			logger.error(e);
			return false;
		}
	}
	
	@Override
	public boolean addBook(Book book){
		try{
			bookManager.addBook(book);
		return true;
		}catch(Exception e){
			logger.error(e);
			return false;
		}
	}
}
