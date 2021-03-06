package com.senla.bookshop.entities;

import java.io.Serializable;

import com.senla.bookshop.annotations.CsvEntity;
import com.senla.bookshop.annotations.CsvProperty;
import com.senla.bookshop.annotations.enums.PropertyType;

@CsvEntity(fileName = "files/files/data/csv/request.csv")
public class Request implements Serializable{
	
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 1)
	private Integer id;
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 2, keyField="bookInfo")
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
