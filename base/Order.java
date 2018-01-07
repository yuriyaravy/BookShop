package by.home.book.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import by.home.book.repository.OrderManager;

public class Order implements Serializable , Cloneable{
	
	private int id;
	private int [] bookId;
	private String dateOfDeliver;
	private OrderStatus status;
	
	

	public Order() {
		super();
	}

	public Order(int id, int[] bookId,  OrderStatus status) {
		this.id = id;
		this.bookId = bookId;
//		this.price = price;
		this.status = status;
	}

	public Order(int id, int[] bookId,  String dateOfDeliver, OrderStatus status) {
		this.id = id;
		this.bookId = bookId;
		this.dateOfDeliver = dateOfDeliver;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateOfDeliver() {
		return dateOfDeliver;
	}

	public void setDateOfDeliver(String dateOfDeliver) {
		this.dateOfDeliver = dateOfDeliver;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public int[] getBookId() {
		return bookId;
	}

	public void setBookId(int[] bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", bookId=" + Arrays.toString(bookId) + ", dateOfDeliver=" + dateOfDeliver
				+ ", status=" + status + "]";
	}
	
	@Override
	public Order clone() throws CloneNotSupportedException {
		Order cloneOrder = (Order)super.clone();
		cloneOrder.setBookId(bookId);
		cloneOrder.setStatus(OrderStatus.PROCESSING);
		return cloneOrder;
  }
	
	
	
	
}
