package com.senla.bookshop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	private Integer id;
	private AuthUser authUser;
	private String name;
	private String surname;
	
	public User(Integer id, AuthUser authUser, String name, String surname) {
		super();
		this.id = id;
		this.authUser = authUser;
		this.name = name;
		this.surname = surname;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	public AuthUser getAuthUser() {
		return authUser;
	}

	public void setAuthUser(AuthUser authUser) {
		this.authUser = authUser;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "surname")
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Column(name = "name")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
