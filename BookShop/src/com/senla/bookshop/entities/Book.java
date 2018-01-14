package com.senla.bookshop.entities;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
	
	private Integer id;
	private String name;
	private Double price;
	private Boolean status = false;
	private Integer yearOfPublication;
	private Date date;
	private Integer countOfRequest;
	
	
	
	public Book() {
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
