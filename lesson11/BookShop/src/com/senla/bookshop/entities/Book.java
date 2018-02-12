package com.senla.bookshop.entities;

import java.io.Serializable;
import java.util.Date;

import com.senla.bookshop.annotations.CsvEntity;
import com.senla.bookshop.annotations.CsvProperty;
import com.senla.bookshop.annotations.enums.PropertyType;

@CsvEntity(fileName = "files/files/data/csv/book.csv")
public class Book implements Serializable{
	
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 1, keyField="bookInfo")
	private Integer id;
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 2, keyField="bookInfo")
	private String name;
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 3, keyField="bookInfo")
	private Double price;
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 4)
	private Boolean status = false;
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 5, keyField="bookInfo")
	private Integer yearOfPublication;
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 6)
	private Date date;
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 7)
	private Integer countOfRequest;
	
	
	
	public Book() {
	}
	
	
	
	public Book(Integer id, String name, Double price, Boolean status, Integer yearOfPublication, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.status = status;
		this.yearOfPublication = yearOfPublication;
		this.date = date;
	}

	public Book(Integer id, String name, Double price,Integer yearOfPublication, Boolean status) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.status = status;
		this.yearOfPublication = yearOfPublication;
		this.date = new Date();
		this.countOfRequest = 0;
	}
	
	public Book(Integer id, String name, Double price, Boolean status, Integer yearOfPublication, Date date,
			Integer countOfRequest) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.status = status;
		this.yearOfPublication = yearOfPublication;
		this.date = date;
		this.countOfRequest = countOfRequest;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public int getYearOfPublication() {
		return yearOfPublication;
	}
	public void setYearOfPublication(Integer yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public Integer getCountOfRequest() {
		return countOfRequest;
	}
	public void setCountOfRequest(Integer countOfRequest) {
		this.countOfRequest = countOfRequest;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", status=" + status + ", yearOfPublication="
				+ yearOfPublication + ", date=" + date + "]";
	}
	
		
	
}
