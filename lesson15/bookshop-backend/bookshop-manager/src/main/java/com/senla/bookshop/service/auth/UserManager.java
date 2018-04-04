package com.senla.bookshop.service.auth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.bookshop.api.controller.IUserManager;
import com.senla.bookshop.api.dao.IAuthUserDao;
import com.senla.bookshop.api.dao.IUserDao;
import com.senla.bookshop.entity.AuthUser;
import com.senla.bookshop.entity.User;

@Service("userManager")
@Transactional
public class UserManager implements IUserManager {

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IAuthUserDao authUserDao;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		userDao.create(session, user);
	}

	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		userDao.update(session, user);
	}

	@Override
	public User getAuthUser(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		AuthUser authUser = authUserDao.getById(session, id);
		User user = userDao.getUserData(authUser, session);
		return user;
	}

	@Override
	public User getAuthUser(AuthUser authUser) {
		Session session = sessionFactory.getCurrentSession();
		User user = userDao.getUserData(authUser, session);
		return user;
	}

	@Override
	public void registraton(String name, String surname, String password) {
		Session session = sessionFactory.getCurrentSession();
		User newUser = new User(null, (new AuthUser(null, name, password)), name, surname);
		userDao.create(session, newUser);
	}

}
