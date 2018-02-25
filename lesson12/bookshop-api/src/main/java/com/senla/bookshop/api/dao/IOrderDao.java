package com.senla.bookshop.api.dao;

import java.util.List;

import com.mysql.jdbc.Connection;
import com.senla.bookshop.entiti.Order;

public interface IOrderDao extends IGenericDao<Order>{

	List<Order> getOrderByDateOfDelivered(Connection connection);

	List<Order> getOrderByStatus(Connection connection);

	List<Double> getAllOrderByPrice(Connection connection);

	List<Order> getOrderById(Connection connection);

	List<Double> getProfitByPeriodOfTime(Connection connection, int day);


}
