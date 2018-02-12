package com.senla.bookshop.managers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;


import com.senla.bookshop.api.controllers.IOrderManager;
import com.senla.bookshop.dao.api.IOrderDao;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.enums.OrderStatus;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;
import com.senla.bookshop.utils.annotations.AnnotationCSVWriter;

public class OrderManager implements IOrderManager{
	
	private final IOrderDao orderStorage = (IOrderDao) DependencyIngection.getInctance().getClassInstance(IOrderDao.class);
	
	@Override
	public void getAnnotationOrder() throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ParseException, SQLException{
		orderStorage.create((Order) AnnotationCSVReader.readerFromCsv(Order.class));
	}
	
	@Override
	public double getProfitForAllOrders(){
		double profit = 0;
		synchronized (orderStorage) {
			for(Double tempReq : orderStorage.getAllOrderByPrice()){
				profit += tempReq;
			}
		}
		return profit;
	}
	@Override
	public void orderCompleate(int id) throws SQLException{
		synchronized (orderStorage) {
			Order order = orderStorage.getById(id);
			order.setStatus(OrderStatus.COMPLEATE);
			orderStorage.update(order);
		}
	}
	@Override
	public  void allOrderCompleate() throws SQLException{
		synchronized (orderStorage) {
			for(Order temp : orderStorage.getOrderById()){
				temp.setStatus(OrderStatus.COMPLEATE);
				orderStorage.update(temp);
			}
		}
	}
			
	@Override
	public Order getOrderById(int id){
		return orderStorage.getById(id);
	}

	@Override
	public void addBookToOrder(Book book) throws SQLException{
		synchronized (orderStorage) {
			Order order = new Order();
			order.setBook(book);
			order.setStatus(OrderStatus.PROCESSING);
			orderStorage.create(order);
		}
	}
	@Override
	public void deleteOrder(int id) throws SQLException{
		synchronized (orderStorage) {
			orderStorage.delete(id);
		}
	}
	@Override
	public void cancelOrder(int id) throws SQLException{
		synchronized (orderStorage) {
			Order cancelOrder = orderStorage.getById(id);
			cancelOrder.setStatus(OrderStatus.CANCELED);
			orderStorage.update(cancelOrder);
		}
	}
	@Override
	public int getCountOfOrder(){
		int profit = orderStorage.getOrderById().size();
		return profit;
	}
	@Override
	public List<Order> getOrderByDateOfDelivered(){
		return orderStorage.getOrderByDateOfDelivered();
	}
	@Override
	public List<Order> getOrderByStatus(){
		return orderStorage.getOrderByStatus();
	}
	@Override
	public List<Double> getOrderByPrice(){
		return orderStorage.getAllOrderByPrice();
	}
	@Override
	public List<Double> getProfitByPeriodOfTime(int day){
		return orderStorage.getProfitByPeriodOfTime(day);
	}
	@Override
	public void saveOrderToCSV() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException{
		AnnotationCSVWriter aw = new AnnotationCSVWriter();
		aw.wtiteToCSVFile(orderStorage.getOrderById());
	}
	@Override
	public void readOrderFromCSV(){
	}
	@Override
	public List<Order> getOrders(){
		return orderStorage.getOrderById();
	}
	
	@Override
	public Order cloneOrder(Order order) throws CloneNotSupportedException {
		Order clone = null;
			clone = order.clone();
		return clone;
	}
	
}
