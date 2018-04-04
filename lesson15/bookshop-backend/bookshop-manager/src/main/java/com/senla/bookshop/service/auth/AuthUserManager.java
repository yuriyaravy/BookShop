package com.senla.bookshop.service.auth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.bookshop.api.controller.IAuthUserManager;
import com.senla.bookshop.api.dao.IAuthUserDao;
import com.senla.bookshop.entity.AuthUser;

@Service("bookManager")
@Transactional
public class AuthUserManager implements IAuthUserManager {

	@Autowired
	private IAuthUserDao authUserDao;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(AuthUser authUser) {
		Session session = sessionFactory.getCurrentSession();
		authUserDao.create(session, authUser);
	}

	@Override
	public void updateUser(AuthUser authUser) {
		Session session = sessionFactory.getCurrentSession();
		authUserDao.update(session, authUser);
	}

	@Override
	public Integer checkAuthUser(AuthUser authUser) {
		Session session = sessionFactory.getCurrentSession();
		Integer authUserId = authUserDao.checkUser(authUser.getLogin(), authUser.getPassword(), session);
		return authUserId;
	}

}
