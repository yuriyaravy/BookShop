package by.home.book.base;

import java.io.Serializable;

public class Request implements Serializable{
	
	private int id;
	private Book book;
	
	public Request(int id, Book book) {
		this.id = id;
		this.book = book;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
