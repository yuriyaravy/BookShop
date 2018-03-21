package com.senla.bookshop.manager.auth;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.senla.bookshop.api.controller.IUserManager;
import com.senla.bookshop.dao.model.AuthUserDao;
import com.senla.bookshop.dao.model.UserDao;
import com.senla.bookshop.entity.AuthUser;
import com.senla.bookshop.entity.User;
import com.senla.bookshop.utils.hibernate.HibernateUtil;

public class UserManager implements IUserManager{
	
	private static final Logger LOGGER = LogManager.getLogger(UserManager.class);
	
	private final UserDao userDao = new UserDao();
	private AuthUserDao authUserDao = new AuthUserDao();
	private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	
	@Override
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			userDao.create(session , user);
			session.getTransaction().commit();
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
				LOGGER.error(e);
		} 
	}

	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			userDao.update(session , user);
			session.getTransaction().commit();
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
				LOGGER.error(e);
		} 
	}

	@Override
	public User getAuthUser(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			AuthUser authUser = authUserDao.getById(session, id);
			User user = userDao.getUserData(authUser, session);
			session.getTransaction().commit();
			return user;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
				LOGGER.error(e);
		} 
		return null;
	}
	
	@Override
	public User getAuthUser(AuthUser authUser) {
		Session session = sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			User user = userDao.getUserData(authUser, session);
			session.getTransaction().commit();
			return user;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
				LOGGER.error(e);
		} 
		return null;
	}
	
	@Override
	public void registraton(String name, String surname, String password ) {
		Session session = sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			User newUser = new User(null,( new AuthUser(null, name, password)), name, surname);
			userDao.create(session, newUser);
			
			session.getTransaction().commit();
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
				LOGGER.error(e);
		} 
	}
	
	
}
