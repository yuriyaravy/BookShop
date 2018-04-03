package com.senla.bookshop.dao.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.senla.bookshop.api.dao.IGenericDao;

@Repository
public abstract class AbstractDao<T> implements IGenericDao<T> {

	protected Class<T> clazz;

	public AbstractDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void create(Session session, T object) {
		session.save(object);
	}

	@Override
	public void delete(Session session, T object) {
		session.delete(object);
	}

	@Override
	public void update(Session session, T object) {
		session.update(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Session session, String... sortingColumn) {
		if (sortingColumn.length > 0 | sortingColumn == null) {
			return session.createCriteria(returnClass()).add(Restrictions.isNotNull(sortingColumn[0]))
					.addOrder(Order.asc(sortingColumn[0])).list();
		}
		return session.createCriteria(returnClass()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Session session, Integer id) {
		return (T) session.get(returnClass(), id);
	}

	protected Class<T> returnClass() {
		return clazz;
	}

}
