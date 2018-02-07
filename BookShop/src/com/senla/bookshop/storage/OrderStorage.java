package com.senla.bookshop.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.annotations.DiStorage;
import com.senla.bookshop.api.storages.IOrderStorage;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.utils.txtwork.TextDeserializ;

@DiStorage
public class OrderStorage implements IOrderStorage{
	
	private List<Order> orderBooks = new ArrayList<>();
	
	private static OrderStorage orderStorage;
	
	private Integer lastId = 0;
	
	public OrderStorage(){
	}
	
	public static OrderStorage getInstance(){
		if(orderStorage == null){
			orderStorage = new OrderStorage();
		}
		return orderStorage;
	}
	private Integer idOrderSetter(){
		return lastId++;
	}
	
	@Override
	public void addOrders(Order order) {
		order.setId(idOrderSetter());
		orderBooks.add(order);
	}

	@Override
	public List<Order> getOrdersBooks() {
		return orderBooks;
	}

	@Override
	public void setOrderBooks(List<Order> orderBooks) {
		this.orderBooks = orderBooks;
	}
		
	@Override
	public List<Order> getSortOrders(Comparator<Order> comparator){
		if(comparator != null){
			Collections.sort(orderBooks, comparator);
		}
		return orderBooks;
	}
	@Override
	public Order getOrderById(int id){
		Order current  = null;
		for(Order temp : orderBooks) {
			if(temp.getId() == id){
				current = temp;
				break;
			}
		}
		return current;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void fillUpOrderStorage(String key){
		TextDeserializ textDeserializ = new TextDeserializ();
		List<Order> booksFromTxt = (List<Order>) textDeserializ.textDeserialez(key);
		setOrderBooks(booksFromTxt);
	}
	
}
