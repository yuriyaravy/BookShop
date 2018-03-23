package com.senla.bookshop.dao.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.senla.bookshop.api.dao.IRequestDao;
import com.senla.bookshop.entity.Request;

public class RequestDao extends AbstractDao<Request> implements IRequestDao {

	public RequestDao() {
		super(Request.class);
	}

	private static final String SELECT_BOOK_REQUEST_HQL = "From Book as book, Request as req WHERE book.id=req.book";

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllRequestsBook(Session session) {
		List<Object[]> books = null;
		Query query = session.createQuery(SELECT_BOOK_REQUEST_HQL);
		books = query.list();
		return books;
	}

	@Override
	public List<Request> getRequest(Session session) {
		return getAll(session);
	}

}
