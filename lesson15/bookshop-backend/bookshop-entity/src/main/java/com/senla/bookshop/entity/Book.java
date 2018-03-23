package com.senla.bookshop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.senla.bookshop.annotations.CsvEntity;
import com.senla.bookshop.annotations.CsvProperty;
import com.senla.bookshop.annotations.enums.PropertyType;

@Entity
@Table(name = "books")
@CsvEntity(fileName = "files/files/data/csv/book.csv")
public class Book implements Serializable {

	private static final long serialVersionUID = -8193180247283226091L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 1, keyField = "bookInfo")
	private Integer id;

	@Column(name = "name")
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 2, keyField = "bookInfo")
	private String name;

	@Column(name = "price")
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 3, keyField = "bookInfo")
	private Double price;

	@Column(name = "status")
	@Type(type = "yes_no")
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 4)
	private Boolean status = false;

	@Column(name = "yearOfPublication")
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 5, keyField = "bookInfo")
	private Integer yearOfPublication;

	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 6)
	private Date date;

	@Column(name = "countOfRequest")
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 7)
	private Integer countOfRequest;

	public Book() {
	}

	public Book(Integer id, String name, Double price, Boolean status, Integer yearOfPublication) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.status = status;
		this.yearOfPublication = yearOfPublication;
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
