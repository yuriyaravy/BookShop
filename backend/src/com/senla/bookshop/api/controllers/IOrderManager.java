package backend.src.com.senla.bookshop.api.controllers;

import java.util.ArrayList;
import java.util.Comparator;

import backend.src.com.senla.bookshop.entities.Order;

public interface IOrderManager {

	public double getProfitForAllOrders();
	
	public void orderCompleate(int id);
	
	public  void allOrderCompleate();
	
	public void getProfitByPeriodOfTime(int day);
	
	public double getProfitForOneOrder(Order order);
	
	public Order getOrderById(int id);
	
	public void addBookToOrder(int[] bookId);
	
	public void deleteBookToOrder(int id);
	
	public void cancelOrder(int id);
	
	public int getCountOfOrder();

	ArrayList<Order> getOrders(Comparator<Order> comparator);

	void saveOrderToCSV(int id);

	ArrayList<String> readOrderFromCSV();

	ArrayList<Order> getOrders();

	Order cloneOrder(Order order);

	public void serializationForOrder();

}
