package com.senla.bookshop.api.dao;

import java.util.List;

import org.hibernate.Session;

public interface IGenericDao<T> {
	
	void create(Session session, T object);
	
	void delete(Session session, T object);
	
	void update(Session session, T object);

	T getById(Session session, Integer id);

	List<T> getAll(Session session, String[] sortingColumn);


}
