package com.senla.bookshop.api.dao;

import org.hibernate.Session;

import com.senla.bookshop.entity.AuthUser;
import com.senla.bookshop.entity.User;

public interface IUserDao extends IGenericDao<User>{
	
	User getUserData(AuthUser authUser, Session session);

}
