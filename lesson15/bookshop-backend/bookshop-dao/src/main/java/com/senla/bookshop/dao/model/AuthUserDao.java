package com.senla.bookshop.dao.model;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.senla.bookshop.api.dao.IAuthUserDao;
import com.senla.bookshop.entity.AuthUser;

public class AuthUserDao extends AbstractDao<AuthUser> implements IAuthUserDao{

	public AuthUserDao() {
		super(AuthUser.class);
	}

	@Override
	public Integer checkUser(String login, String password, Session session) {
		Criteria criteria = session.createCriteria(AuthUser.class).add(Restrictions.like("login", login))
				.add(Restrictions.like("password", password));
		AuthUser checked = (AuthUser) criteria.uniqueResult();
		return checked.getId();
	}

	@Override
	public AuthUser getAuthUser(String login, String password, Session session) {
		Criteria criteria = session.createCriteria(AuthUser.class).add(Restrictions.like("login", login))
				.add(Restrictions.like("password", password));
		AuthUser authUser = (AuthUser) criteria.uniqueResult();
		return authUser;
	}

}
