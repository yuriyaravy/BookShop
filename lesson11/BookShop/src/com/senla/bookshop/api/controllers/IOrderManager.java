package com.senla.bookshop.api.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;

public interface IOrderManager {

	void getAnnotationOrder() throws FileNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException, ParseException, SQLException;

	double getProfitForAllOrders();

	void orderCompleate(int id) throws SQLException;

	void allOrderCompleate() throws SQLException;

	Order getOrderById(int id);

	void addBookToOrder(Book book) throws SQLException;

	void deleteOrder(int id) throws SQLException;

	void cancelOrder(int id) throws SQLException;

	int getCountOfOrder();

	List<Order> getOrderByDateOfDelivered();

	List<Order> getOrderByStatus();

	void saveOrderToCSV() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException;

	Order cloneOrder(Order order) throws CloneNotSupportedException;

	void readOrderFromCSV();

	List<Order> getOrders();

	List<Double> getOrderByPrice();

	List<Double> getProfitByPeriodOfTime(int day);


}
