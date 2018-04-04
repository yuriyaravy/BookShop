package com.senla.bookshop.service.auth;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.senla.bookshop.api.controller.IAuthUserManager;
import com.senla.bookshop.dao.model.AuthUserDao;
import com.senla.bookshop.entity.AuthUser;

public class AuthUserManager implements IAuthUserManager {

	private static final Logger LOGGER = LogManager.getLogger(UserManager.class);

	private  AuthUserDao authUserDao = new AuthUserDao();
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(AuthUser authUser) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			authUserDao.create(session, authUser);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void updateUser(AuthUser authUser) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			authUserDao.update(session, authUser);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public Integer checkAuthUser(AuthUser authUser) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Integer authUserId = authUserDao.checkUser(authUser.getLogin(), authUser.getPassword(), session);
			session.getTransaction().commit();
			return authUserId;
		} catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			LOGGER.error(e.getMessage());
			return null;
		}
	}

}
