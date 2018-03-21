package com.senla.bookshop.api.controller;

import com.senla.bookshop.entity.AuthUser;

public interface IAuthUserManager {

	void addUser(AuthUser authUser);

	void updateUser(AuthUser authUser);

	Integer checkAuthUser(AuthUser authUser);

}
