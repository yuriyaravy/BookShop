package backend.src.com.senla.bookshop.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import org.apache.log4j.Logger;

import backend.src.com.senla.bookshop.api.controllers.IOrderManager;
import backend.src.com.senla.bookshop.entities.Book;
import backend.src.com.senla.bookshop.entities.Order;
import backend.src.com.senla.bookshop.enums.OrderStatus;
import backend.src.com.senla.bookshop.storage.BookStorage;
import backend.src.com.senla.bookshop.storage.OrderStorage;
import backend.src.com.senla.bookshop.utils.DateManager;
import backend.src.com.senla.bookshop.utils.OtherSorting;
import backend.src.com.senla.bookshop.utils.csvworker.PathStorage;
import backend.src.com.senla.bookshop.utils.csvworker.ReadFromCSV;
import backend.src.com.senla.bookshop.utils.csvworker.SaveObjectToCSV;
import backend.src.com.senla.bookshop.utils.txtworker.TextSerializ;

public class OrderManager implements IOrderManager{
	
	private static final Logger logger = Logger.getLogger(OrderManager.class);
	
	@Override
	public double getProfitForAllOrders(){
		double profit = 0;
		for(Order tempReq : OrderStorage.getInstance().getOrdersBooks()){
			profit += getProfitForOneOrder(tempReq);
		}
		return profit;
	}
	@Override
	public void orderCompleate(int id){
			Order order = getOrderById(id);
			order.setStatus(OrderStatus.COMPLEATE);
			order.setDateOfDeliver(DateManager.setDate());
	}
	@Override
	public  void allOrderCompleate(){
		for(Order temp : OrderStorage.getInstance().getOrdersBooks()){
			temp.setStatus(OrderStatus.COMPLEATE);
			temp.setDateOfDeliver(DateManager.setDate());
		}
	}
	@Override
	public void getProfitByPeriodOfTime(int day){
		for(Order temp : OtherSorting.sortBooksByDate(day))
		System.out.println(getProfitForOneOrder(temp));
	}
	
	@Override
	public double getProfitForOneOrder(Order order){
		BookManager bookById = new BookManager();
		double profit = 0;
		for(int bookId :  order.getBookId()){
			Book book = bookById.getBookById(bookId);
			if(book != null){
			profit += book.getPrice();
			}
		}
		return profit;
	}
	@Override
	public Order getOrderById(int id){
		Order current  = null;
		for(Order temp : OrderStorage.getInstance().getOrdersBooks()) {
			if(temp.getId() == id){
				current = temp;
				break;
			}
		}
		return current;
	}

	@Override
	public void addBookToOrder(int[] bookId){
		try{
			Order order = new Order();
			order.setBookId(bookId);
			order.setStatus(OrderStatus.PROCESSING);
			OrderStorage.getInstance().getOrdersBooks().add(order);
		}catch(Exception ex){
			logger.error(ex);
		}
	}
	@Override
	public void deleteBookToOrder(int id){
		try{
			Iterator<Order> ite = OrderStorage.getInstance().getOrdersBooks().iterator();
			while(ite.hasNext()){
				Order temp = ite.next();
				if(temp.getId() == id){
					ite.remove();
				}
			}
		}catch(Exception ex){
			logger.error(ex);
		}
	}
	@Override
	public void cancelOrder(int id){
		try{
			Order cancelOrder = getOrderById(id);
			cancelOrder.setStatus(OrderStatus.CANCELED);
		}catch(Exception ex){
			logger.error(ex);
		}
	}
	@Override
	public int getCountOfOrder(){
		int profit = OrderStorage.getInstance().getOrdersBooks().size();
		return profit;
	}
	@Override
	public ArrayList<Order> getOrders(Comparator<Order> comparator){
		return OrderStorage.getInstance().getSortOrders(comparator);
	}
	@Override
	public void saveOrderToCSV(int id){
		SaveObjectToCSV.orderWriteToCSV(id);
	}
	@Override
	public ArrayList<String> readOrderFromCSV(){
		return ReadFromCSV.readCSV(new PathStorage().getCsvOrderFile());
	}
	@Override
	public ArrayList<Order> getOrders(){
		return OrderStorage.getInstance().getOrdersBooks();
	}
	
	@Override
	public Order cloneOrder(Order order) {
		Order clone = null;
		try {
			clone = order.clone();
		} catch (CloneNotSupportedException e) {
			logger.error(e);
     		}
		return clone;
	}
	@Override
	public void serializationForOrder() {
		TextSerializ.getInstance().textOrderSerial(OrderStorage.getInstance().getOrdersBooks());
	}
}
