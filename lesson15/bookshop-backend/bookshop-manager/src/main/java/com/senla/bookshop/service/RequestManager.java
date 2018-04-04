package com.senla.bookshop.service;

import java.util.List;
import java.util.stream.DoubleStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.bookshop.api.controller.IRequestManager;
import com.senla.bookshop.api.dao.IRequestDao;
import com.senla.bookshop.entity.Request;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;
import com.senla.bookshop.utils.annotations.AnnotationCSVWriter;

@Service("requestManager")
@Transactional
public class RequestManager implements IRequestManager {

	@Autowired
	private IRequestDao requestDao;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void getAnnotationRequest() throws Exception {
		requestDao.update(sessionFactory.openSession(), (Request) AnnotationCSVReader.readerFromCsv(Request.class));
	}

	@Override
	public void saveAnnotationRequest() throws Exception {
		List<Request> list = requestDao.getAll(sessionFactory.openSession(), null);
		AnnotationCSVWriter.wtiteToCSVFile(list);
	}

	@Override
	public void addRequest(Request request) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		requestDao.create(session, request);
		session.getTransaction().commit();
	}

	@Override
	public List<Object[]> getAllBookRequestByName() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objects = requestDao.getAllRequestsBook(session);
		return objects;
	}

	@Override
	public Double getAllBookRequestByAmount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Double price = null;
		List<Request> list = requestDao.getRequest(session);
		for (Request temp : list) {
			price = DoubleStream.of(temp.getBook().getPrice()).sum();
		}
		session.getTransaction().commit();
		return price;
	}

	@Override
	public List<Request> getRequest() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Request> requests = requestDao.getRequest(session);
		return requests;
	}

	@Override
	public Request getRequestById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Request request = requestDao.getById(session, id);
		return request;
	}

	@Override
	public void deleteRequest(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		requestDao.delete(session, requestDao.getById(session, new Integer(id)));
	}

}
