package com.senla.bookshop.dao.api;

import java.util.List;

import com.senla.bookshop.entities.Order;

public interface IOrderDao extends IDataBaseDao<Order>{

	List<Order> getOrderByDateOfDelivered();

	List<Order> getOrderByStatus();

	List<Double> getAllOrderByPrice();

	List<Order> getOrderById();

	List<Double> getProfitByPeriodOfTime(int day);


}
