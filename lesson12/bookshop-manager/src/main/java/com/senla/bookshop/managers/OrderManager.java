package com.senla.bookshop.managers;

import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.senla.bookshop.api.controllers.IOrderManager;
import com.senla.bookshop.api.dao.IOrderDao;
import com.senla.bookshop.dao.connect.DataBaseConnect;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entiti.Order;
import com.senla.bookshop.enums.OrderStatus;
import com.senla.bookshop.hibernate.Book;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;
import com.senla.bookshop.utils.annotations.AnnotationCSVWriter;

public class OrderManager implements IOrderManager{
	
	private static final Logger logger = LogManager.getLogger(BookManager.class);
	
	private final IOrderDao orderDao = (IOrderDao) DependencyIngection.getInctance().getClassInstance(IOrderDao.class);
	private DataBaseConnect dbconnect = DataBaseConnect.getInstance();
	
	
	
	@Override
	public void getAnnotationOrder() throws Exception{
		orderDao.update((Connection) dbconnect.getConnection(),(Order) AnnotationCSVReader.readerFromCsv(Order.class));
	}
	@Override
	public void saveAnnotationOrder() throws Exception{
		List<Order> list = orderDao.getOrderById((Connection) dbconnect.getConnection());
		AnnotationCSVWriter.wtiteToCSVFile(list);
	}
	@Override
	public double getProfitForAllOrders() throws Exception{
		List<Double> myList = orderDao.getAllOrderByPrice((Connection) dbconnect.getConnection());
		return myList.stream().mapToDouble(f -> f.doubleValue()).sum();
	}
	@Override
	public void orderCompleate(int id) throws Exception{
		synchronized (orderDao) {
			Order order = orderDao.getById((Connection) dbconnect.getConnection(),id);
			order.setStatus(OrderStatus.COMPLEATE);
			orderDao.update((Connection) dbconnect.getConnection(),order);
		}
	}
	@Override
	public  void allOrderCompleate() throws Exception{
		synchronized (orderDao) {
			List<Order> orderList = orderDao.getOrderById((Connection) dbconnect.getConnection());
			for(Order temp : orderList){
				temp.setStatus(OrderStatus.COMPLEATE);
				orderDao.update((Connection) dbconnect.getConnection(),temp);
			}
		}
	}
			
	@Override
	public Order getOrderById(int id) throws Exception{
		return orderDao.getById((Connection) dbconnect.getConnection(),id);
	}

	@Override
	public void addBookToOrder(Book book) throws Exception{
		Connection connection = (Connection) dbconnect.getConnection();
		Savepoint savepoint = null;
		try{
			connection.setAutoCommit(false);
			savepoint = connection.setSavepoint();
			Order order = new Order();
			order.setBook(book);
			order.setStatus(OrderStatus.PROCESSING);
			orderDao.create((Connection) dbconnect.getConnection(),order);
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				connection.rollback(savepoint);
			} catch (SQLException e1) {
				logger.error(e1);
			}
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
	@Override
	public void deleteOrder(int id) throws Exception{
		synchronized (orderDao) {
			orderDao.delete((Connection) dbconnect.getConnection(),id);
		}
	}
	@Override
	public void cancelOrder(int id) throws Exception{
		synchronized (orderDao) {
			Order cancelOrder = orderDao.getById((Connection) dbconnect.getConnection(),id);
			cancelOrder.setStatus(OrderStatus.CANCELED);
			orderDao.update((Connection) dbconnect.getConnection(),cancelOrder);
		}
	}
	@Override
	public int getCountOfOrder() throws Exception{
		return orderDao.getOrderById((Connection) dbconnect.getConnection()).size();
	}
	@Override
	public List<Order> getOrderByDateOfDelivered() throws Exception{
		return orderDao.getOrderByDateOfDelivered((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Order> getOrderByStatus() throws Exception{
		return orderDao.getOrderByStatus((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Double> getOrderByPrice() throws Exception{
		return orderDao.getAllOrderByPrice((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Double> getProfitByPeriodOfTime(int day) throws Exception{
		return orderDao.getProfitByPeriodOfTime((Connection) dbconnect.getConnection(),day);
	}
	@Override
	public void saveOrderToCSV() throws Exception{
		AnnotationCSVWriter.wtiteToCSVFile(orderDao.getOrderById((Connection) dbconnect.getConnection()));
	}
	@Override
	public List<Order> getOrders() throws Exception{
		return orderDao.getOrderById((Connection) dbconnect.getConnection());
	}
	@Override
	public Order cloneOrder(Order order) throws SQLException, Exception {
		Order clone = null;
			clone = order.clone();
			orderDao.create((Connection) dbconnect.getConnection(), clone);
		return clone;
	}
	
}
