package com.senla.bookshop.dao.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.senla.bookshop.api.dao.IOrderDao;
import com.senla.bookshop.entity.Order;
import com.senla.bookshop.enums.OrderStatus;

public class OrderDao extends AbstractDao<Order> implements IOrderDao{
	
	public OrderDao() {
		super(Order.class);
	}
	private static final String ID_ORDER = "id_order";
	private static final String DATE_OF_DELIVERY = "date_of_deliver;";
	private static final String ORDER_STATUS = "order_status";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getCompletedOrder(Session session){
		return session.createCriteria(Order.class)
				.add(Restrictions.eq("status", OrderStatus.COMPLEATE.toString())).list();
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
