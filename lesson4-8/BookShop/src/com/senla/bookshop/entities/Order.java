package com.senla.bookshop.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.senla.bookshop.annotations.CsvEntity;
import com.senla.bookshop.annotations.CsvProperty;
import com.senla.bookshop.annotations.enums.PropertyType;
import com.senla.bookshop.enums.OrderStatus;
import com.senla.bookshop.storage.OrderStorage;

@CsvEntity(fileName = "files/files/data/csv/order.csv")
public class Order implements Serializable , Cloneable{
	
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 1)
	private Integer id;
	@CsvProperty(propertyType = PropertyType.CompositeProperty, columnNumber = 2, keyField="bookInfo")
	private List<Book> book;
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 3)
	private Date dateOfDeliver;
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 4)
	private OrderStatus status;

	public Order() {
		super();
	}
	
	public Order(Integer id, List<Book> book, Date dateOfDeliver, OrderStatus status) {
		this.id = id;
		this.book = book;
		this.dateOfDeliver = dateOfDeliver;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public Date getDateOfDeliver() {
		return dateOfDeliver;
	}

	public void setDateOfDeliver(Date dateOfDeliver) {
		this.dateOfDeliver = dateOfDeliver;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", book=" + book + ", dateOfDeliver=" + dateOfDeliver + ", status=" + status + "]";
	}

	@Override
	public Order clone() throws CloneNotSupportedException {
		Order cloneOrder = (Order)super.clone();
		cloneOrder.setId(0);
		return cloneOrder;
  }
	
}
