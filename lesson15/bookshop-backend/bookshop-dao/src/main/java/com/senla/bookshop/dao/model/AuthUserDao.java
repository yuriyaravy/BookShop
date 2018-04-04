package com.senla.bookshop.dao.model;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.senla.bookshop.api.dao.IAuthUserDao;
import com.senla.bookshop.entity.AuthUser;

@Repository
public class AuthUserDao extends AbstractDao<AuthUser> implements IAuthUserDao {

	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";

	public AuthUserDao() {
		super(AuthUser.class);
	}

	@Override
	public Integer checkUser(String login, String password, Session session) {
		Criteria criteria = session.createCriteria(AuthUser.class).add(Restrictions.like(LOGIN, login))
				.add(Restrictions.like(PASSWORD, password));
		AuthUser checked = (AuthUser) criteria.uniqueResult();
		return checked.getId();
	}

	@Override
	public AuthUser getAuthUser(String login, String password, Session session) {
		Criteria criteria = session.createCriteria(AuthUser.class).add(Restrictions.like(LOGIN, login))
				.add(Restrictions.like(PASSWORD, password));
		AuthUser authUser = (AuthUser) criteria.uniqueResult();
		return authUser;
	}

}
