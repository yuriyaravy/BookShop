package com.senla.bookshop.api.service;

import com.senla.bookshop.entity.AuthUser;

public interface IAuthUserManager {

	void addUser(AuthUser authUser);

	void updateUser(AuthUser authUser);

	Integer checkAuthUser(AuthUser authUser);

}
