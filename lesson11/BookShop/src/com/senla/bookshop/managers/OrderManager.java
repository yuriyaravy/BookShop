package com.senla.bookshop.managers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.senla.bookshop.api.controllers.IOrderManager;
import com.senla.bookshop.dao.api.IOrderDao;
import com.senla.bookshop.dao.connect.DataBaseConnect;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.enums.OrderStatus;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;
import com.senla.bookshop.utils.annotations.AnnotationCSVWriter;

public class OrderManager implements IOrderManager{
	
	private final IOrderDao orderStorage = (IOrderDao) DependencyIngection.getInctance().getClassInstance(IOrderDao.class);
	private DataBaseConnect dbconnect = DataBaseConnect.getInstance();
	
	@Override
	public void getAnnotationOrder() throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ParseException, SQLException{
		orderStorage.create((Connection) dbconnect.getConnection(),(Order) AnnotationCSVReader.readerFromCsv(Order.class));
	}
	
	@Override
	public double getProfitForAllOrders(){
		double profit = 0;
		synchronized (orderStorage) {
			for(Double tempReq : orderStorage.getAllOrderByPrice((Connection) dbconnect.getConnection())){
				profit += tempReq;
			}
		}
		return profit;
	}
	@Override
	public void orderCompleate(int id) throws SQLException{
		synchronized (orderStorage) {
			Order order = orderStorage.getById((Connection) dbconnect.getConnection(),id);
			order.setStatus(OrderStatus.COMPLEATE);
			orderStorage.update((Connection) dbconnect.getConnection(),order);
		}
	}
	@Override
	public  void allOrderCompleate() throws SQLException{
		synchronized (orderStorage) {
			for(Order temp : orderStorage.getOrderById((Connection) dbconnect.getConnection())){
				temp.setStatus(OrderStatus.COMPLEATE);
				orderStorage.update((Connection) dbconnect.getConnection(),temp);
			}
		}
	}
			
	@Override
	public Order getOrderById(int id){
		return orderStorage.getById((Connection) dbconnect.getConnection(),id);
	}

	@Override
	public void addBookToOrder(Book book) throws SQLException{
		synchronized (orderStorage) {
			Order order = new Order();
			order.setBook(book);
			order.setStatus(OrderStatus.PROCESSING);
			orderStorage.create((Connection) dbconnect.getConnection(),order);
		}
	}
	@Override
	public void deleteOrder(int id) throws SQLException{
		synchronized (orderStorage) {
			orderStorage.delete((Connection) dbconnect.getConnection(),id);
		}
	}
	@Override
	public void cancelOrder(int id) throws SQLException{
		synchronized (orderStorage) {
			Order cancelOrder = orderStorage.getById((Connection) dbconnect.getConnection(),id);
			cancelOrder.setStatus(OrderStatus.CANCELED);
			orderStorage.update((Connection) dbconnect.getConnection(),cancelOrder);
		}
	}
	@Override
	public int getCountOfOrder(){
		int profit = orderStorage.getOrderById((Connection) dbconnect.getConnection()).size();
		return profit;
	}
	@Override
	public List<Order> getOrderByDateOfDelivered(){
		return orderStorage.getOrderByDateOfDelivered((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Order> getOrderByStatus(){
		return orderStorage.getOrderByStatus((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Double> getOrderByPrice(){
		return orderStorage.getAllOrderByPrice((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Double> getProfitByPeriodOfTime(int day){
		return orderStorage.getProfitByPeriodOfTime((Connection) dbconnect.getConnection(),day);
	}
	@Override
	public void saveOrderToCSV() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException{
		AnnotationCSVWriter aw = new AnnotationCSVWriter();
		aw.wtiteToCSVFile(orderStorage.getOrderById((Connection) dbconnect.getConnection()));
	}
	@Override
	public void readOrderFromCSV(){
	}
	@Override
	public List<Order> getOrders(){
		return orderStorage.getOrderById((Connection) dbconnect.getConnection());
	}
	
	@Override
	public Order cloneOrder(Order order) throws CloneNotSupportedException {
		Order clone = null;
			clone = order.clone();
		return clone;
	}
	
}
