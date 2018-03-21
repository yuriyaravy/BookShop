package com.senla.bookshop.api.dao;

import org.hibernate.Session;

import com.senla.bookshop.entity.AuthUser;

public interface IAuthUserDao extends IGenericDao<AuthUser>{
	
	Integer checkUser(String login, String password, Session session);

	AuthUser getAuthUser(String login, String password, Session session);

}
