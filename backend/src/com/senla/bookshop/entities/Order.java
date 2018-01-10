package backend.src.com.senla.bookshop.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import backend.src.com.senla.bookshop.enums.OrderStatus;

public class Order implements Serializable , Cloneable{
	
	private int id;
	private int [] bookId;
	private Date dateOfDeliver;
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

	public Order(int id, int[] bookId,  Date dateOfDeliver, OrderStatus status) {
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
