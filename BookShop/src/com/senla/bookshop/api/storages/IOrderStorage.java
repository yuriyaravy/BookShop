package com.senla.bookshop.api.storages;

import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.entities.Order;

public interface IOrderStorage {
	
	void addOrders(Order order);
	
	List<Order> getOrdersBooks();
	
	void setOrderBooks(List<Order> orderBooks);

	List<Order> getSortOrders(Comparator<Order> comparator);

	Order getOrderById(int id);

	void fillUpOrderStorage(String key);

}
