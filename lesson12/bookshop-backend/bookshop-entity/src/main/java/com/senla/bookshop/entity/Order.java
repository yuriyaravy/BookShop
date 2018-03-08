package com.senla.bookshop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.senla.bookshop.annotations.CsvEntity;
import com.senla.bookshop.annotations.CsvProperty;
import com.senla.bookshop.annotations.enums.PropertyType;
import com.senla.bookshop.enums.OrderStatus;

@Entity
@Table(name="orders")
@CsvEntity(fileName = "files/files/data/csv/order.csv")
public class Order implements Serializable , Cloneable{
	
	private static final long serialVersionUID = -1311635413752160170L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 1)
	private Integer id;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "order_books", 
				joinColumns = @JoinColumn(name = "book_id"),
				inverseJoinColumns = @JoinColumn(name = "order_id"))
	@CsvProperty(propertyType = PropertyType.CompositeProperty, columnNumber = 2, keyField="bookInfo")
	private List<Book> books;
	
	
	@Column(name="date_of_deliver")
	@Temporal(TemporalType.DATE)
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 3)
	private Date dateOfDeliver;
	
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	@CsvProperty(propertyType = PropertyType.SimpleProperty, columnNumber = 4)
	private OrderStatus status;

	public Order() {
		super();
	}
	
	public Order(List<Book> books, Date dateOfDeliver, OrderStatus status) {
		this.books = books;
		this.dateOfDeliver = dateOfDeliver;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
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
		return "Order [id=" + id + ", books=" + books + ", dateOfDeliver=" + dateOfDeliver + ", status=" + status + "]";
	}

	@Override
	public Order clone() throws CloneNotSupportedException {
		Order cloneOrder = (Order)super.clone();
		cloneOrder.setId(0);
		return cloneOrder;
  }
	
}
