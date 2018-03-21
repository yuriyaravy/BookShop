package com.senla.bookshop.manager;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.DoubleStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.senla.bookshop.api.controller.IOrderManager;
import com.senla.bookshop.api.dao.IOrderDao;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entity.Book;
import com.senla.bookshop.entity.Order;
import com.senla.bookshop.enums.OrderStatus;
import com.senla.bookshop.utils.DateManager;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;
import com.senla.bookshop.utils.annotations.AnnotationCSVWriter;
import com.senla.bookshop.utils.hibernate.HibernateUtil;

public class OrderManager implements IOrderManager{
	
	private static final Logger LOGGER = LogManager.getLogger(BookManager.class);
	
	private final IOrderDao orderDao = (IOrderDao) DependencyIngection.getInctance().getClassInstance(IOrderDao.class);
	private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	
	@Override
	public void getAnnotationOrder() throws Exception{
		orderDao.update(sessionFactory.openSession(),(Order) AnnotationCSVReader.readerFromCsv(Order.class));
	}
	
	@Override
	public void saveAnnotationOrder() throws Exception{
		List<Order> list = orderDao.getAll(sessionFactory.openSession(), null);
		AnnotationCSVWriter.wtiteToCSVFile(list);
	}
	@Override
	public double getProfitForAllOrders() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Double price = null;
		try{
			List<Order> myList = orderDao.getAll(session, null);
			for(Order order : myList){
				price = DoubleStream.of(((Book) order.getBooks()).getPrice()).sum();
		}
			return price;
		}catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return 0;
		}
		
	}
	@Override
	public void orderCompleate(int id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			Order order = orderDao.getById(session,id);
			order.setStatus(OrderStatus.COMPLEATE);
			orderDao.update(sessionFactory.openSession(),order);
			session.getTransaction().commit();
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
		}
	}
	
	@Override
	public  void allOrderCompleate() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			List<Order> orderList = orderDao.getAll(session, null);
				for(Order temp : orderList){
					temp.setStatus(OrderStatus.COMPLEATE);
					orderDao.update(sessionFactory.openSession(),temp);
				}
			session.getTransaction().commit();
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
		}
	}
			
	@Override
	public Order getOrderById(int id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Order order = null;
		try{
			session.beginTransaction();
			order = orderDao.getById(session,id);
			session.getTransaction().commit();
			return order;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addBookToOrder(Book book) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			Order order = new Order();
			order.setBooks((List<Book>) book);
			order.setStatus(OrderStatus.PROCESSING);
			orderDao.create(session,order);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
		} 
	}
	@Override
	public void deleteOrder(Order order) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			orderDao.delete(session, order);
			session.getTransaction().commit();
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
		}
	}
	
	@Override
	public void cancelOrder(int id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			Order cancelOrder = orderDao.getById(session,id);
			cancelOrder.setStatus(OrderStatus.CANCELED);
			orderDao.update(session,cancelOrder);
			session.getTransaction().commit();
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
		}
	}
	@Override
	public int getCountOfOrder() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			List<Order> orders = orderDao.getAll(session, null);
			session.getTransaction().commit();
			return orders.size();
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return 0;
		}
	}
	
	@Override
	public List<Order> getOrderByDateOfDelivered() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Order> orders = null;
		try{
			session.beginTransaction();
			orders = orderDao.sortOrderByDateOfDelivered(session);
			session.getTransaction().commit();
			return orders;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		}
	}
	
	@Override
	public List<Order> getOrderByStatus() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Order> orders = null;
		try{
			session.beginTransaction();
			orders = orderDao.sortOrderByStatus(session);
			session.getTransaction().commit();
			return orders;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		}
	}
	
	@Override
	public Double getOrderByPrice() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Double profit = null;
		try{
			List<Order> list = orderDao.getAll(session, null);
			for(Order temp : list){
				profit = DoubleStream.of(((Book) temp.getBooks()).getPrice()).sum();
			}
			return profit;
		}catch(HibernateException e){
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		}
	}
	
	@Override
	public Double getProfitByPeriodOfTime(int day) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Date dateNow = DateManager.setDate();
		Date dateFromOrder;
		Double profit = null;
		try{
			List<Order> list = orderDao.getCompletedOrder(session);
			for(Order temp : list){
				dateFromOrder = temp.getDateOfDeliver();
				long difference = dateNow.getTime() - dateFromOrder.getTime();
				int days = (int) (difference /(24 * 60 *60 * 1000));
				if(days > day){
					profit = DoubleStream.of(((Book) temp.getBooks()).getPrice()).sum();
				}
			}
				return profit;
		}catch(HibernateException e){
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		}
	}
	
	@Override
	public void saveOrderToCSV() throws Exception{
		AnnotationCSVWriter.wtiteToCSVFile(orderDao.getAll(sessionFactory.openSession(), null));
	}
	@Override
	public List<Order> getOrders() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Order> orders = null;
		try{
			session.beginTransaction();
			orders = orderDao.getAll(session , null);
			session.getTransaction().commit();
			return orders;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		}
	}
	
	@Override
	public Order cloneOrder(int id) throws SQLException, Exception {
		Session session = sessionFactory.getCurrentSession();
		Order clone = null;
		try{
				Order order = orderDao.getById(session, id);
				clone = order.clone();
				session.beginTransaction();
				orderDao.create(session, clone);
				session.getTransaction().commit();
				return clone;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		} 
	}
	
}
