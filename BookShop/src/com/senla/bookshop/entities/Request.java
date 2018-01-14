package com.senla.bookshop.entities;

import java.io.Serializable;

public class Request implements Serializable{
	
	private Integer id;
	private Book book;
	
	public Request() {
	}
	
	
	public Request(Book book) {
		this.book = book;
	}
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", book=" + book + "]";
	}
	
	
	
}
