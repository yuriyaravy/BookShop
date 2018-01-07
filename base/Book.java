package by.home.book.base;

import java.io.Serializable;

public class Book implements Serializable{
	
	private int id;
	private String name;
	private double price;
	private boolean status = false;
	private int yearOfPublication;
	private String date;
	private int countOfRequest;
	
	
	
	public Book() {
	}
	public Book(int id, String name, double price, int yearOfPublication, boolean status, String date) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.status = status;
		this.yearOfPublication = yearOfPublication;
		this.date = date;
		this.countOfRequest = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getYearOfPublication() {
		return yearOfPublication;
	}
	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public int getCountOfRequest() {
		return countOfRequest;
	}
	public void setCountOfRequest(int countOfRequest) {
		this.countOfRequest = countOfRequest;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", status=" + status + ", yearOfPublication="
				+ yearOfPublication + ", date=" + date + "]";
	}
	
		
	
}
