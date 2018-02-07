package com.senla.bookshop.managers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.bookshop.api.controllers.IOrderManager;
import com.senla.bookshop.api.storages.IBookStorage;
import com.senla.bookshop.api.storages.IOrderStorage;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.enums.OrderStatus;
import com.senla.bookshop.storage.BookStorage;
import com.senla.bookshop.storage.OrderStorage;
import com.senla.bookshop.storage.RequestStorage;
import com.senla.bookshop.utils.DateManager;
import com.senla.bookshop.utils.OtherSorting;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;
import com.senla.bookshop.utils.csvwork.ParseToObject;
import com.senla.bookshop.utils.csvwork.ReadFromCSV;
import com.senla.bookshop.utils.csvwork.SaveObjectToCSV;
import com.senla.bookshop.utils.setting.Setting;
import com.senla.bookshop.utils.txtwork.TextSerializ;

public class OrderManager implements IOrderManager{
	
	private final IOrderStorage orderStorage = (IOrderStorage) DependencyIngection.getInctance().getClassInstance(IOrderStorage.class);
	
	private static final Logger logger = Logger.getLogger(OrderManager.class);
	
	private final String PROPARTY_KEY = "orderPath";
	
	private final String PROPARTY_KEY_CSV = "orderPathCSV";
	
	@SuppressWarnings("unchecked")
	@Override
	public void getAnnotationOrder() throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ParseException{
		orderStorage.setOrderBooks((List<Order>) AnnotationCSVReader.readerFromCsv(Order.class));
	}
	
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
		double profit = 0;
		for(Book book :  order.getBook()){
			if(book != null){
			profit += book.getPrice();
			}
		}
		return profit;
	}
	@Override
	public Order getOrderById(int id){
		return orderStorage.getOrderById(id);
	}

	@Override
	public void addBookToOrder(List<Book> book) throws Exception{
			Order order = new Order();
			order.setBook(book);
			order.setStatus(OrderStatus.PROCESSING);
			OrderStorage.getInstance().getOrdersBooks().add(order);
	}
	@Override
	public void deleteBookToOrder(int id) throws Exception{
			Iterator<Order> ite = OrderStorage.getInstance().getOrdersBooks().iterator();
			while(ite.hasNext()){
				Order temp = ite.next();
				if(temp.getId() == id){
					ite.remove();
				}
		}
	}
	@Override
	public void cancelOrder(int id) throws Exception{
			Order cancelOrder = getOrderById(id);
			cancelOrder.setStatus(OrderStatus.CANCELED);
	}
	@Override
	public int getCountOfOrder(){
		int profit = orderStorage.getOrdersBooks().size();
		return profit;
	}
	@Override
	public List<Order> getOrders(Comparator<Order> comparator){
		return orderStorage.getSortOrders(comparator);
	}
	@Override
	public void saveOrderToCSV(){
		SaveObjectToCSV.orderWriteToCSV();
	}
	@Override
	public void readOrderFromCSV() throws ParseException{
		List<Order> csvOrders = ParseToObject.stringToOrder(ReadFromCSV.readCSV(PROPARTY_KEY_CSV));
		for(Order tempCSV : csvOrders){
			for(int i = 0; i < orderStorage.getOrdersBooks().size(); i++){
				if(tempCSV.getId() != orderStorage.getOrdersBooks().get(i).getId()){
				}
			}
			orderStorage.addOrders(tempCSV);
		}
	}
	@Override
	public List<Order> getOrders(){
		return orderStorage.getOrdersBooks();
	}
	
	@Override
	public Order cloneOrder(Order order) throws CloneNotSupportedException {
		Order clone = null;
			clone = order.clone();
		return clone;
	}
	@Override
	public void serializationForOrder() {
		TextSerializ.textSerialize(OrderStorage.getInstance().getOrdersBooks(), PROPARTY_KEY);
	}
	@Override
	public void fillUpOrderStorage(){
		orderStorage.fillUpOrderStorage(PROPARTY_KEY);
	}
}
