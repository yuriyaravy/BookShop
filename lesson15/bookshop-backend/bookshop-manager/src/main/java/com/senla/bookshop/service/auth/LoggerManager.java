package com.senla.bookshop.service.auth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.bookshop.api.dao.ILoggerDao;
import com.senla.bookshop.api.service.ILoggerManager;
import com.senla.bookshop.dao.model.AbstractDao;
import com.senla.bookshop.dao.model.LoggerDao;
import com.senla.bookshop.entity.Log;

@Service("bookManager")
@Transactional
public class LoggerManager implements ILoggerManager {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ILoggerDao logDao;

	@SuppressWarnings("unchecked")
	@Override
	public void addLog(Log logg) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		((AbstractDao<LoggerDao>) logDao).create(session, (LoggerDao) logDao);

	}

}
