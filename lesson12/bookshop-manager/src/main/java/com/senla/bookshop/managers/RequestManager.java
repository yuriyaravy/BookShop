package com.senla.bookshop.managers;

import java.util.List;
import java.util.stream.DoubleStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.senla.bookshop.api.controllers.IRequestManager;
import com.senla.bookshop.api.dao.IRequestDao;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entiti.Request;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;
import com.senla.bookshop.utils.annotations.AnnotationCSVWriter;
import com.senla.bookshop.utils.hibernate.HibernateUtil;

public class RequestManager implements IRequestManager{
	
	private static final Logger logger = LogManager.getLogger(RequestManager.class);
	
	
	private final IRequestDao requestDao = (IRequestDao) DependencyIngection.getInctance().getClassInstance(IRequestDao.class);
	private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	
	@Override
	public void getAnnotationRequest() throws Exception{
		requestDao.update(sessionFactory.openSession(),(Request) AnnotationCSVReader.readerFromCsv(Request.class));
	}
	@Override
	public void saveAnnotationRequest() throws Exception{
		List<Request> list = requestDao.getAll(sessionFactory.openSession(), null);
		AnnotationCSVWriter.wtiteToCSVFile(list);
	}
	
	@Override
	public void addRequest(Request request) throws Exception{
		Session session = sessionFactory.openSession();
		try{
			session.beginTransaction();
			requestDao.create(session, request);
			session.getTransaction().commit();
		} catch (HibernateException  e) {
				session.getTransaction().rollback();
				logger.error(e);
		} finally {
				session.close();
		}
	}
	
	@Override
	public List<Object[]> getAllBookRequestByName() throws Exception{
		Session session = sessionFactory.openSession();
		List<Object[]> objects = null;
		try{
			session.beginTransaction();
			objects = requestDao.getAllRequestsBook(session);
			session.getTransaction().commit();
			return objects;
		} catch (HibernateException  e) {
			session.getTransaction().rollback();
			logger.error(e);
			return null;
		} finally {
			session.close();
		}
	}
	
	@Override
	public Double getAllBookRequestByAmount() throws Exception{
		Double price = null;
		List<Request> list = requestDao.getRequest(sessionFactory.openSession());
		for(Request temp : list){
			price = DoubleStream.of(temp.getBook().getPrice()).sum();
		}
		return price;
	}
	@Override
	public List<Request> getRequest() throws Exception{
		Session session = sessionFactory.openSession();
		List<Request> requests = null;
		try{
			session.beginTransaction();
			requests = requestDao.getRequest(session);
			session.getTransaction().commit();
			return requests;
		} catch (HibernateException  e) {
			session.getTransaction().rollback();
			logger.error(e);
			return null;
		} finally {
			session.close();
		}
	}

}
