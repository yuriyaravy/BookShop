package com.senla.bookshop.dao.api;

import java.util.List;

import com.mysql.jdbc.Connection;
import com.senla.bookshop.entities.Order;

public interface IOrderDao extends IDataBaseDao<Order>{

	List<Order> getOrderByDateOfDelivered(Connection connection);

	List<Order> getOrderByStatus(Connection connection);

	List<Double> getAllOrderByPrice(Connection connection);

	List<Order> getOrderById(Connection connection);

	List<Double> getProfitByPeriodOfTime(Connection connection, int day);


}
