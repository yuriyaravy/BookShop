package com.senla.bookshop.api.controller;

import java.sql.SQLException;
import java.util.List;

import com.senla.bookshop.entity.Book;
import com.senla.bookshop.entity.Order;

public interface IOrderManager {

	void getAnnotationOrder() throws Exception;

	double getProfitForAllOrders() throws Exception;

	void orderCompleate(int id) throws Exception;

	void allOrderCompleate() throws  Exception;

	Order getOrderById(int id) throws Exception;

	void addBookToOrder(Book book) throws  Exception;

	void cancelOrder(int id) throws  Exception;

	int getCountOfOrder() throws Exception;

	List<Order> getOrderByDateOfDelivered() throws Exception;

	List<Order> getOrderByStatus() throws Exception;

	void saveOrderToCSV() throws Exception;


	List<Order> getOrders() throws Exception;

	Double getOrderByPrice() throws Exception;

	Double getProfitByPeriodOfTime(int day) throws Exception;

	void saveAnnotationOrder() throws Exception;

	void deleteOrder(Order order) throws Exception;

	Order cloneOrder(int id) throws SQLException, Exception;


}
