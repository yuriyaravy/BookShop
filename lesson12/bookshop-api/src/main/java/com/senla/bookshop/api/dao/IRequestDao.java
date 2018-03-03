package com.senla.bookshop.api.dao;

import java.util.List;

import org.hibernate.Session;

import com.senla.bookshop.entiti.Request;

public interface IRequestDao extends IGenericDao<Request>{

	List<Object[]> getAllRequestsBook(Session session);

	List<Request> getRequest(Session session);

	
}
