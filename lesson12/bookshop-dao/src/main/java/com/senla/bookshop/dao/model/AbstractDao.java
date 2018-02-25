package com.senla.bookshop.dao.model;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.Order;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mysql.jdbc.Connection;
import com.senla.bookshop.api.dao.IGenericDao;

public abstract class AbstractDao <T> implements IGenericDao<T>{
	
	private static final Logger logger = LogManager.getLogger(AbstractDao.class);
	
	protected Class<T> clazz;
	
	public void create(Session session, T object) {
		session.save(object);
	}
	
	public void delete(Session session,  T object){
		session.delete(object);
	}
	
	public void update(Session session,T object){
		session.update(object);
	}

	public List<T> getAll(Session session, Class<T> type){
		Criteria crit = session.createCriteria(type);
		return crit.list();
	}

	public T getById(Session session, Integer id){
		return (T) session.get(returnClass(), id);
	}
	
	protected Class<T> returnClass(){
		return clazz;
	}

}
