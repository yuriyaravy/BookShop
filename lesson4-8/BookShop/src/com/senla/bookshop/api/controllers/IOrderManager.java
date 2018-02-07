package com.senla.bookshop.api.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;

public interface IOrderManager {

	double getProfitForAllOrders();
	
	void orderCompleate(int id);
	
	void allOrderCompleate();
	
	void getProfitByPeriodOfTime(int day);
	
	double getProfitForOneOrder(Order order);
	
	Order getOrderById(int id);
	
	void deleteBookToOrder(int id) throws Exception;
	
	void cancelOrder(int id) throws Exception;
	
	int getCountOfOrder();

	List<Order> getOrders(Comparator<Order> comparator);

	void readOrderFromCSV() throws ParseException;

	List<Order> getOrders();

	Order cloneOrder(Order order) throws CloneNotSupportedException;

	public void serializationForOrder();

	void addBookToOrder(List<Book> book) throws Exception;

	void fillUpOrderStorage();

	void saveOrderToCSV();

	void getAnnotationOrder() throws FileNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException, ParseException;


}
