package com.senla.bookshop.service;

import java.util.List;
import java.util.stream.DoubleStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.senla.bookshop.api.controller.IRequestManager;
import com.senla.bookshop.api.dao.IRequestDao;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entity.Request;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;
import com.senla.bookshop.utils.annotations.AnnotationCSVWriter;

public class RequestManager implements IRequestManager{
	
	private static final Logger LOGGER = LogManager.getLogger(RequestManager.class);
	
	
	private final IRequestDao requestDao = (IRequestDao) DependencyIngection.getInctance().getClassInstance(IRequestDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
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
		Session session = sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			requestDao.create(session, request);
			session.getTransaction().commit();
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
				LOGGER.error(e);
		} 
	}
	
	@Override
	public List<Object[]> getAllBookRequestByName() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objects = null;
		try{
			session.beginTransaction();
			objects = requestDao.getAllRequestsBook(session);
			session.getTransaction().commit();
			return objects;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		} 
	}
	
	@Override
	public Double getAllBookRequestByAmount() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Double price = null;
		List<Request> list = null;
		try{
			session.beginTransaction();
			list = requestDao.getRequest(session);
			for(Request temp : list){
				price = DoubleStream.of(temp.getBook().getPrice()).sum();
			}
			session.getTransaction().commit();
			return price;
		}catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		} 
	
	
	}
	@Override
	public List<Request> getRequest() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Request> requests = null;
		try{
			session.beginTransaction();
			requests = requestDao.getRequest(session);
			session.getTransaction().commit();
			return requests;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		} 
	}
	
	@Override
	public Request getRequestById(int id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Request request = null;
		try{
			session.beginTransaction();
			request = requestDao.getById(session, id);
			session.getTransaction().commit();
			return request;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		}
	}
	
	@Override
	public void deleteRequest(int id) throws Exception {
		Session session = null; 
		try{
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			requestDao.delete(session, requestDao.getById(session, new Integer(id)));
			session.getTransaction().commit();
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
		} 
	}

}
