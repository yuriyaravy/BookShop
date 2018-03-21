package com.senla.bookshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.senla.bookshop.annotations.CsvEntity;
import com.senla.bookshop.annotations.CsvProperty;
import com.senla.bookshop.annotations.enums.PropertyType;

@Entity
@Table(name="requests")
@CsvEntity(fileName = "files/files/data/csv/request.csv")
public class Request implements Serializable{
	
	private static final long serialVersionUID = 2203288805903871087L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="request_id")
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 1)
	private Integer id;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "book_id", nullable = true)
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
