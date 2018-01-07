package by.home.book.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import by.home.book.DAO.TextDeserializ;
import by.home.book.DAO.TextLogger;
import by.home.book.DAO.TextSerializ;
import by.home.book.base.Book;
import by.home.book.base.Order;
import by.home.book.base.OrderStatus;
import by.home.book.fasade.properties.Setting;
import by.home.book.instruments.DateManager;
import by.home.book.instruments.Id;
import by.home.book.services.OtherSorting;


public class OrderManager {
	
	public static ArrayList<Order> orderBooks = new ArrayList<>();
	
	public static void showAllOrders(){
		for(Order temp : orderBooks){
			System.out.println(temp);
		}
	}
	
	public static double getProfitForAllOrders(){
		double profit = 0;
		for(Order tempReq : orderBooks){
			profit += getProfitForOneOrder(tempReq);
		}
		return profit;
	}
	
	public static void orderCompleate(int id){
		boolean allow = Setting.isOrderCompleate();
		if(!allow){
			Order order = getOrderById(id);
			order.setStatus(OrderStatus.COMPLEATE);
			order.setDateOfDeliver(DateManager.setStringDate());
		}else{
			System.out.println("You can't do it maybe you don't have permit");
		}
	}
	
	public static void allOrderCompleate(){
		boolean allow = Setting.isOrderCompleate();
		if(!allow){
		for(Order temp : orderBooks){
			temp.setStatus(OrderStatus.COMPLEATE);
			temp.setDateOfDeliver(DateManager.setStringDate());
		}
		}else{
			System.out.println("You can't do it maybe you don't have permit");
		}
	}
	
	public static void getProfitByPeriodOfTime(int day){
		for(Order temp : OtherSorting.sortBooksByDate(day))
		System.out.println(getProfitForOneOrder(temp));
	}
	
	
	public static double getProfitForOneOrder(Order order){
		double profit = 0;
		for(int bookId :  order.getBookId()){
			Book book = BookManager.getBookById(bookId);
			if(book != null){
			profit += book.getPrice();
			}
		}
		return profit;
	}
	
	public static Order getOrderById(int id){
		Order current  = null;
		for(Order temp : orderBooks) {
			if(temp.getId() == id){
				current = temp;
				break;
			}
		}
		return current;
	}
	// возможно бесполезный метод
	public static Order getOrders(){
		Order order = null;
			Iterator<Order> ite = orderBooks.iterator();
			while(ite.hasNext()){
				order = ite.next();
				return order;
			}
		return order;
	}
	
	public static void addBookToOrder(int ...v){
		try{
			Order order = new Order();
			order.setBookId(v);
			order.setStatus(OrderStatus.PROCESSING);
			order.setId(Id.creationId());
			orderBooks.add(order);
		}catch(Exception ex){
			TextLogger.exceptLog(ex);
		}
	}
	
	public static void deleteBookToOrder(int id){
		try{
			Iterator<Order> ite = orderBooks.iterator();
			while(ite.hasNext()){
				Order temp = ite.next();
				if(temp.getId() == id){
					ite.remove();
				}
			}
		}catch(Exception ex){
			TextLogger.exceptLog(ex);
		}
	}
	
	public static void cancelOrder(int id){
		try{
			Order cancelOrder = getOrderById(id);
			cancelOrder.setStatus(OrderStatus.CANCELED);
		}catch(Exception ex){
			TextLogger.exceptLog(ex);
		}
	}
	
	public static int getCountOfOrder(){
		int profit = orderBooks.size();
		return profit;
	}
	
	public static void cloneOrder(Order order){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter how many books will be in your order: ");
		int size = input.nextInt();
		int array[] = new int[size];
		System.out.println("Insert id books:");
		for (int i = 0; i < size; i++){
			array[i] = input.nextInt();
		}
		System.out.println("Enter status can be (COMPLEATE, CANCELED, PROCESSING)");
		OrderStatus value = OrderStatus.valueOf(input.next().toUpperCase());
		Order copyOrder = new Order();
		try{
			copyOrder = order.clone();
			order.setId(Id.creationId());
			order.setBookId(array);
			order.setStatus(value);
			if(value == OrderStatus.COMPLEATE){
				order.setDateOfDeliver(DateManager.setStringDate());
			}
			orderBooks.add(copyOrder);
			TextSerializ.getInstance().textOrderSerial(OrderManager.orderBooks);
		}catch(CloneNotSupportedException ex){
			TextLogger.exceptLog(ex);
		}
	}

}
