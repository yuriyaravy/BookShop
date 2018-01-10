package backend.src.com.senla.bookshop.api.controllers;

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

}
