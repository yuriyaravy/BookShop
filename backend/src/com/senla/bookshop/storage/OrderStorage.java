package backend.src.com.senla.bookshop.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import backend.src.com.senla.bookshop.api.storages.IOrderStorage;
import backend.src.com.senla.bookshop.entities.Order;

public class OrderStorage implements IOrderStorage{
	
	private ArrayList<Order> orderBooks = new ArrayList<>();
	
	private static OrderStorage orderStorage;
	
	private OrderStorage(){
	}

	
	public static OrderStorage getInstance(){
		if(orderStorage == null){
			orderStorage = new OrderStorage();
		}
		return orderStorage;
	}
	
	@Override
	public void addOrders(Order order) {
		order.setId(orderBooks.size()-1);
		orderBooks.add(order);
	}

	@Override
	public ArrayList<Order> getOrdersBooks() {
		return orderBooks;
	}

	@Override
	public void setOrderBooks(ArrayList<Order> orderBooks) {
		this.orderBooks = orderBooks;
	}
	
	private void sortOrders(ArrayList<Order> order, Comparator<Order> comparator){
		if(comparator != null){
			Collections.sort(order, comparator);
		}
	}
	@Override
	public ArrayList<Order> getSortOrders(Comparator<Order> comparator){
		sortOrders(orderBooks, comparator);
		return orderBooks;
	}

	
}
