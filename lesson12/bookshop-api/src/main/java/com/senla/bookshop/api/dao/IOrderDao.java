package com.senla.bookshop.api.dao;

import java.util.List;

import org.hibernate.Session;

import com.senla.bookshop.entiti.Order;

public interface IOrderDao extends IGenericDao<Order>{

	List<Order> sortOrderByStatus(Session session);

	List<Order> sortOrderByDateOfDelivered(Session session);

	List<Order> sortOrderById(Session session);

	List<Order> getCompletedOrder(Session session);

}
