package com.senla.bookshop.api.controllers;

import java.sql.SQLException;
import java.util.List;

import com.senla.bookshop.entiti.Book;
import com.senla.bookshop.entiti.Order;

public interface IOrderManager {

	void getAnnotationOrder() throws Exception;

	double getProfitForAllOrders() throws Exception;

	void orderCompleate(int id) throws SQLException, Exception;

	void allOrderCompleate() throws SQLException, Exception;

	Order getOrderById(int id) throws Exception;

	void addBookToOrder(Book book) throws SQLException, Exception;

	void deleteOrder(int id) throws SQLException, Exception;

	void cancelOrder(int id) throws SQLException, Exception;

	int getCountOfOrder() throws Exception;

	List<Order> getOrderByDateOfDelivered() throws Exception;

	List<Order> getOrderByStatus() throws Exception;

	void saveOrderToCSV() throws Exception;

	Order cloneOrder(Order order) throws CloneNotSupportedException, SQLException, Exception;

	List<Order> getOrders() throws Exception;

	List<Double> getOrderByPrice() throws Exception;

	List<Double> getProfitByPeriodOfTime(int day) throws Exception;

	void saveAnnotationOrder() throws Exception;


}
