package backend.src.com.senla.bookshop.facade;

import java.util.ArrayList;

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
import backend.src.com.senla.bookshop.storage.OrderStorage;
import backend.src.com.senla.bookshop.utils.comparators.book.ComparatorBookByDate;
import backend.src.com.senla.bookshop.utils.comparators.book.ComparatorBookByName;
import backend.src.com.senla.bookshop.utils.comparators.book.ComparatorBookByPrice;
import backend.src.com.senla.bookshop.utils.comparators.book.ComparatorBookByStatus;
import backend.src.com.senla.bookshop.utils.comparators.book.ComparatorBookByYearOfPublic;
import backend.src.com.senla.bookshop.utils.comparators.order.ComparatorDateOfDeliver;
import backend.src.com.senla.bookshop.utils.comparators.order.ComparatorOrderByDate;
import backend.src.com.senla.bookshop.utils.comparators.order.ComparatorOrderByPrice;
import backend.src.com.senla.bookshop.utils.comparators.order.ComparatorOrderByStatus;
import backend.src.com.senla.bookshop.utils.comparators.order.ComparatorOrderBydateOfCompleate;
import backend.src.com.senla.bookshop.utils.comparators.request.ComparatorForRequestByAmount;
import backend.src.com.senla.bookshop.utils.comparators.request.ComparatorRequestByName;

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
	@Override
	public ArrayList<Request> sortRequestByName(){
		return requestManager.getRequests(new ComparatorRequestByName());
	}
	@Override
	public ArrayList<Request> sortRequestAmounte(){
		return requestManager.getRequests(new ComparatorForRequestByAmount());
	}
	@Override
	public ArrayList<Order> sortOrderByDateOfDeliver(){
		return orderManager.getOrders(new ComparatorDateOfDeliver());
	}
	@Override
	public ArrayList<Order> sortOrderByDate(){
		return orderManager.getOrders(new ComparatorOrderByDate());
	}
	@Override
	public ArrayList<Order> sortOrderByDateOfCompleate(){
		return orderManager.getOrders(new ComparatorOrderBydateOfCompleate());
	}
	@Override
	public ArrayList<Order> sortOrderByPrice(){
		return orderManager.getOrders(new ComparatorOrderByPrice());
	}
	@Override
	public ArrayList<Order> sortOrderByStatus(){
		return orderManager.getOrders(new ComparatorOrderByStatus());
	}
	@Override
	public ArrayList<Order> sortOrderByCompleate(){
		return orderManager.getOrders(new ComparatorOrderBydateOfCompleate());
	}
	@Override
	public ArrayList<Book> sortBookByDate(){
		return bookManager.getBook(new ComparatorBookByDate());
	}
	@Override
	public ArrayList<Book> sortBookByName(){
		return bookManager.getBook(new ComparatorBookByName());
	}
	@Override
	public ArrayList<Book> sortBookByPrice(){
		return bookManager.getBook(new ComparatorBookByPrice());
	}
	@Override
	public ArrayList<Book> sortBookByStatus(){
		return bookManager.getBook(new ComparatorBookByStatus());
	}
	@Override
	public ArrayList<Book> sortBookByYearOfPublic(){
		return bookManager.getBook(new ComparatorBookByYearOfPublic());
	}
	@Override
	public void saveBookToCSV(int id){
		bookManager.saveBookToCSV(id);
	}
	@Override
	public void saveOrderToCSV(int id){
		orderManager.saveOrderToCSV(id);
	}
	@Override
	public void saveRequestToCSV(int id){
		requestManager.saveRequestToCSV(id);
	}
	@Override
	public ArrayList<String> readRequestFromCSV(){
		return requestManager.readRequestFromCSV();
	}
	@Override
	public ArrayList<String> readBookFromCSV(){
		return bookManager.readBookFromCSV();
	}
	@Override
	public ArrayList<String> readOrderFromCSV(){
		return orderManager.readOrderFromCSV();
	}
	@Override
	public ArrayList<Book> getBooks(){
		return bookManager.getBooks();
	}
	@Override
	public ArrayList<Order> getOrders(){
		return orderManager.getOrders();
	}
	@Override
	public ArrayList<Request> getRequests(){
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
	public void cloneOrder(Order order){
		orderManager.cloneOrder(order);
		OrderStorage.getInstance().getOrdersBooks().add(order);
	}
}
