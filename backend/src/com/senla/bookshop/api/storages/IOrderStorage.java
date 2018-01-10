package backend.src.com.senla.bookshop.api.storages;

import java.util.ArrayList;
import java.util.Comparator;

import backend.src.com.senla.bookshop.entities.Order;

public interface IOrderStorage {
	
	public void addOrders(Order order);
	
	public ArrayList<Order> getOrdersBooks();
	
	public void setOrderBooks(ArrayList<Order> orderBooks);

	public ArrayList<Order> getOrders(Comparator<Order> comparator);

}
