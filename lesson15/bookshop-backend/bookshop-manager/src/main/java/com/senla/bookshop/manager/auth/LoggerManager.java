package com.senla.bookshop.manager.auth;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.senla.bookshop.api.controller.ILoggerManager;
import com.senla.bookshop.dao.model.LoggerDao;
import com.senla.bookshop.entity.Log;
import com.senla.bookshop.manager.RequestManager;
import com.senla.bookshop.utils.hibernate.HibernateUtil;

public class LoggerManager implements ILoggerManager{
	
	private static final Logger LOGGER = LogManager.getLogger(RequestManager.class);
	
	
	private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	private final LoggerDao logDao = new LoggerDao();
	
	@Override
	public void addLog(Log logg) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			logDao.create(session, logDao);
			session.getTransaction().commit();
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
				LOGGER.error(e);
		} 
		
	}

}
