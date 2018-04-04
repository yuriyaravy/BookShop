package com.senla.bookshop.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.DoubleStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.bookshop.api.controller.IOrderManager;
import com.senla.bookshop.api.dao.IOrderDao;
import com.senla.bookshop.entity.Book;
import com.senla.bookshop.entity.Order;
import com.senla.bookshop.enums.OrderStatus;
import com.senla.bookshop.utils.DateManager;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;
import com.senla.bookshop.utils.annotations.AnnotationCSVWriter;

@Service("orderManager")
@Transactional
public class OrderManager implements IOrderManager {

	private static final Logger LOGGER = LogManager.getLogger(OrderManager.class);

	@Autowired
	private IOrderDao orderDao;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void getAnnotationOrder() throws Exception {
		orderDao.update(sessionFactory.openSession(), (Order) AnnotationCSVReader.readerFromCsv(Order.class));
	}

	@Override
	@Transactional
	public void saveAnnotationOrder() throws Exception {
		List<Order> list = orderDao.getAll(sessionFactory.openSession(), null);
		AnnotationCSVWriter.wtiteToCSVFile(list);
	}

	@Override
	@Transactional
	public double getProfitForAllOrders() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Double price = null;
		List<Order> myList = orderDao.getAll(session, null);
		for (Order order : myList) {
			price = DoubleStream.of(((Book) order.getBooks()).getPrice()).sum();
		}
		return price;

	}

	@Override
	@Transactional
	public void orderCompleate(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		try {
			Order order = orderDao.getById(session, id);
			order.setStatus(OrderStatus.COMPLEATE);
			orderDao.update(sessionFactory.openSession(), order);
		} catch (HibernateException e) {
			LOGGER.error(e);
		}
	}

	@Override
	@Transactional
	public void allOrderCompleate() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Order> orderList = orderDao.getAll(session, null);
		for (Order temp : orderList) {
			temp.setStatus(OrderStatus.COMPLEATE);
			orderDao.update(sessionFactory.openSession(), temp);
		}
	}

	@Override
	@Transactional
	public Order getOrderById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Order order = null;
		order = orderDao.getById(session, id);
		return order;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void addBookToOrder(Book book) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Order order = new Order();
		order.setBooks((List<Book>) book);
		order.setStatus(OrderStatus.PROCESSING);
		orderDao.create(session, order);
	}

	@Override
	@Transactional
	public void deleteOrder(Order order) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		orderDao.delete(session, order);
	}

	@Override
	@Transactional
	public void cancelOrder(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Order cancelOrder = orderDao.getById(session, id);
		cancelOrder.setStatus(OrderStatus.CANCELED);
		orderDao.update(session, cancelOrder);
	}

	@Override
	@Transactional
	public int getCountOfOrder() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Order> orders = orderDao.getAll(session, null);
		return orders.size();
	}

	@Override
	@Transactional
	public List<Order> getOrderByDateOfDelivered() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Order> orders = null;
		orders = orderDao.sortOrderByDateOfDelivered(session);
		session.getTransaction().commit();
		return orders;
	}

	@Override
	@Transactional
	public List<Order> getOrderByStatus() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Order> orders = null;
		orders = orderDao.sortOrderByStatus(session);
		return orders;
	}

	@Override
	@Transactional
	public Double getOrderByPrice() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Double profit = null;
		List<Order> list = orderDao.getAll(session, null);
		for (Order temp : list) {
			profit = DoubleStream.of(((Book) temp.getBooks()).getPrice()).sum();
		}
		return profit;
	}

	@Override
	@Transactional
	public Double getProfitByPeriodOfTime(int day) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Date dateNow = DateManager.setDate();
		Date dateFromOrder;
		Double profit = null;
		List<Order> list = orderDao.getCompletedOrder(session);
		for (Order temp : list) {
			dateFromOrder = temp.getDateOfDeliver();
			long difference = dateNow.getTime() - dateFromOrder.getTime();
			int days = (int) (difference / (24 * 60 * 60 * 1000));
			if (days > day) {
				profit = DoubleStream.of(((Book) temp.getBooks()).getPrice()).sum();
			}
		}
		return profit;
	}

	@Override
	@Transactional
	public void saveOrderToCSV() throws Exception {
		AnnotationCSVWriter.wtiteToCSVFile(orderDao.getAll(sessionFactory.openSession(), null));
	}

	@Override
	@Transactional
	public List<Order> getOrders() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Order> orders = orderDao.getAll(session, null);

		return orders;
	}

	@Override
	@Transactional
	public Order cloneOrder(int id) throws SQLException, Exception {
		Session session = sessionFactory.getCurrentSession();
		Order clone = null;
		Order order = orderDao.getById(session, id);
		clone = order.clone();
		session.beginTransaction();
		orderDao.create(session, clone);
		session.getTransaction().commit();
		return clone;
	}

}
