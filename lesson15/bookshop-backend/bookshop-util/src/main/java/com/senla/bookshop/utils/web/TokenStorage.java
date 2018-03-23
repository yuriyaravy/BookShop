package com.senla.bookshop.utils.web;

import java.util.HashMap;
import java.util.Map;

import com.senla.bookshop.entity.User;

public class TokenStorage {

	private static TokenStorage instance;

	private TokenStorage() {
	}

	public static TokenStorage getInstance() {
		if (instance == null) {
			instance = new TokenStorage();
		}
		return instance;
	}

	private Map<User, String> cache = new HashMap<User, String>();

	public void setCache(User user,String token) {
		this.cache.put(user, token);
	}

	public String getToken(User user) {
		if (user != null) {
			return this.cache.get(user);
		} else {
			return null;
		}
	}

	public void deleteToken(User user) {
		if (user != null) {
			this.cache.remove(user);
		}
	}

}
