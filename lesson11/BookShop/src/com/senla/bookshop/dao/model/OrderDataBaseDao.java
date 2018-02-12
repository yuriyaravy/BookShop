package com.senla.bookshop.dao.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.senla.bookshop.dao.api.IOrderDao;
import com.senla.bookshop.dao.connect.DataBaseConnect;
import com.senla.bookshop.dao.utils.DateUtil;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.enums.OrderStatus;

public class OrderDataBaseDao extends ADataBaseDao<Order> implements IOrderDao{
	
	private static final Logger logger = LogManager.getLogger(OrderDataBaseDao.class);
	
	private static final String ID_ORDER = "id_order";
	private static final String ID_BOOK = "id_book";
	private static final String DATE_OF_DELIVERY = "date_of_deliver";
	private static final String ORDER_STATUS = "order_status";
	
	private static final String PRICE_BOOK = "price";
	
	private static final String UPDATE_ORDER = "update orders set id_book=?, date_of_deliver=?, order_status=? where id_order=?"; 
	private static final String INSERT_INTO_ORDER = "insert into orders (id_order, id_book, date_of_deliver, order_status) value (?, ?, ?, ?)";
	private static final String SELECT_FROM_ORDER_BY_ID = "select * from order where id_order = ?";
	private static final String	DELETE_ORDER_BY_ID = "delete from order where id_order = ?";
	private static final String SELECT_ALL_FROM_ORDER = "select * from order";
	
	private static final String SELECT_ORDER_BY_AMOUNT = "select o.price, o.name from book as o, orders as p where o.id_book = p.id_book order by o.price desc;";
	private static final String SELECT_ORDER_PROFIT= "select  o.price, o.name from book as o, orders as p where o.id_book = p.id_book and p.order_status = 'COMPLEATE' and to_days(now()) - to_days(date_of_add) >=";

	@Override
	protected String getIdQuery() {
		return SELECT_FROM_ORDER_BY_ID;
	}

	@Override
	protected String getInsertQuery() {
		return INSERT_INTO_ORDER;
	}

	@Override
	protected String getDeleteQuery() {
		return DELETE_ORDER_BY_ID;
	}

	@Override
	protected String getAllQuery() {
		return SELECT_ALL_FROM_ORDER;
	}

	@Override
	protected String getUpdateQuery() {
		return UPDATE_ORDER;
	}

	@Override
	protected void prepareUpdateStatement(PreparedStatement statement, Order object) throws SQLException {
		statement.setInt(1, object.getId());
		statement.setInt(2, object.getBook().getId());
		statement.setString(3, DateUtil.parserStringFromDate(object.getDateOfDeliver()));
		statement.setString(4, object.getStatus().toString());
	}

	@Override
	protected void prepareInsertStatement(PreparedStatement statement, Order object) throws SQLException {
		statement.setInt(1, object.getId());
		statement.setInt(2, object.getBook().getId());
		statement.setString(3, DateUtil.parserStringFromDate(object.getDateOfDeliver()));
		statement.setString(4, object.getStatus().toString());
	}

	@Override
	protected Order parseEntity(ResultSet resultSet) {
		try {
			Order tempOrder = new Order();
			tempOrder.setId(resultSet.getInt(ID_ORDER));
			if (resultSet.findColumn(ID_BOOK) > 0) {
				BookDataBaseDao bookDao = (BookDataBaseDao) DependencyIngection.getInctance().getClassInstance(BookDataBaseDao.class);
				tempOrder.setBook(bookDao.parseEntity(resultSet));
			}
			tempOrder.setDateOfDeliver(resultSet.getDate(DATE_OF_DELIVERY));
			tempOrder.setStatus(OrderStatus.valueOf(resultSet.getString(ORDER_STATUS)));
			return tempOrder;
		} catch (SQLException e) {
			logger.error(e);
			return null;
		}
		
	}
	@Override
	public List<Double> getProfitByPeriodOfTime(int day) {
		DataBaseConnect.getInstance().Connect();
		Connection dbConnect = (Connection) DataBaseConnect.getInstance().getMysqlConnect();
		List<Double> tempList = new ArrayList<>();
		Statement statement = null;
		try {
			statement = (Statement) dbConnect.createStatement();
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
				statement.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
	@Override
	public List<Double> getAllOrderByPrice() {
		DataBaseConnect.getInstance().Connect();
		Connection dbConnect = (Connection) DataBaseConnect.getInstance().getMysqlConnect();
		List<Double> tempList = new ArrayList<>();
		Statement statement = null;
		try {
			statement = (Statement) dbConnect.createStatement();
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
				statement.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
	@Override
	public List<Order> getOrderByStatus(){
		return getAll(ORDER_STATUS);
	}
	@Override
	public List<Order> getOrderByDateOfDelivered(){
		return getAll(DATE_OF_DELIVERY);
	}
	@Override
	public List<Order> getOrderById(){
		return getAll(ID_ORDER);
	}
	

}
