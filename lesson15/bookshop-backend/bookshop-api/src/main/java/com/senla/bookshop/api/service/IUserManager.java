package com.senla.bookshop.api.service;

import com.senla.bookshop.entity.AuthUser;
import com.senla.bookshop.entity.User;

public interface IUserManager {

	void addUser(User user);

	void updateUser(User user);

	User getAuthUser(Integer id);

	void registraton(String name, String surname, String password);

	User getAuthUser(AuthUser authUser);


}
