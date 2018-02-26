package com.senla.bookshop.dao.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.senla.bookshop.api.dao.IOrderDao;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entiti.Order;
import com.senla.bookshop.enums.OrderStatus;
import com.senla.bookshop.utils.dao.DateUtil;

public class OrderDao extends AbstractDao<Order> implements IOrderDao{
	
	private static final Logger logger = LogManager.getLogger(OrderDao.class);
	
	private static final String ID_ORDER = "id_order";
	private static final String ID_BOOK = "id_book";
	private static final String DATE_OF_DELIVERY = "date_of_deliver;";
	private static final String ORDER_STATUS = "order_status";
	
	private static final String PRICE_BOOK = "price";
	
	private static final String SELECT_ORDER_BY_AMOUNT = "select o.price, o.name from book as o, orders as p where o.id_book = p.id_book order by o.price desc;";
	private static final String SELECT_ORDER_PROFIT= "select  o.price, o.name from book as o, orders as p where o.id_book = p.id_book and p.order_status = 'COMPLEATE' and to_days(now()) - to_days(date_of_add) >=";

	@Override
	public List<Double> getProfitByPeriodOfTime(Connection connection, int day) {
		List<Double> tempList = new ArrayList<>();
		Statement statement = null;
		try {
			statement = (Statement) connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_ORDER_PROFIT+day);
			while (resultSet.next()) {
				tempList.add(resultSet.getDouble(PRICE_BOOK));
			}
			return tempList;
		} catch (SQLException e) {
			logger.error(e);
			return null;
		} finally {
			try {
				if(statement != null){
					statement.close();
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
	@Override
	public List<Double> getAllOrderByPrice(Connection connection) {
		List<Double> tempList = new ArrayList<>();
		Statement statement = null;
		try {
			statement = (Statement) connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_ORDER_BY_AMOUNT);
			while (resultSet.next()) {
				tempList.add(resultSet.getDouble(PRICE_BOOK));
			}
			return tempList;
		} catch (SQLException e) {
			logger.error(e);
			return null;
		} finally {
			try {
				if(statement != null){
					statement.close();
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
	@Override
	public List<Order> sortOrderByStatus(Session session){
		return getAll(session, ORDER_STATUS);
	}
	@Override
	public List<Order> sortOrderByDateOfDelivered(Session session){
		return getAll(session, DATE_OF_DELIVERY);
	}
	@Override
	public List<Order> sortOrderById(Session session){
		return getAll(session, ID_ORDER);
	}
	

}
