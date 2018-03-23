package com.senla.bookshop.dao.model;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.senla.bookshop.api.dao.IUserDao;
import com.senla.bookshop.entity.AuthUser;
import com.senla.bookshop.entity.User;

public class UserDao extends AbstractDao<User> implements IUserDao {

	private static final String AUTH_USER = "authUser";

	public UserDao() {
		super(User.class);
	}

	@Override
	public User getUserData(AuthUser authUser, Session session) {
		User user = (User) session.createCriteria(User.class).add(Restrictions.eq(AUTH_USER, authUser)).uniqueResult();
		return user;
	}

}