package backend.src.com.senla.bookshop.storage;

import java.util.ArrayList;

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
}
