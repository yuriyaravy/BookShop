package by.home.book.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.SortingFocusTraversalPolicy;

import by.home.book.DAO.TextLogger;
import by.home.book.base.Book;
import by.home.book.base.Order;
import by.home.book.fasade.properties.Setting;
import by.home.book.instruments.DateManager;
import by.home.book.repository.OrderManager;

public class OtherSorting {
	
	
	public static void sortOldBooks (ArrayList<Book> old){
		for(Book temp : old){
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			Date dateFromBook = null;
			Date dateNow = DateManager.setDate();
			try {
				dateFromBook = format.parse(temp.getDate());
		      } catch (Exception e) {
		          e.printStackTrace();
		      }
			long difference = dateNow.getTime() - dateFromBook.getTime();
			int days =  (int)(difference / (24 * 60 * 60 * 1000));
			if(days > (Setting.getMonth()*30)){
				System.out.println(temp);
			}
		}
	}
	
	public static ArrayList<Order> sortBooksByDate (int month){
		ArrayList<Order> order = OrderManager.orderBooks;
		ArrayList<Order> orderByDate = new ArrayList<>();
		for(Order temp : order){
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			Date dateFromBook = null;
			Date dateNow = DateManager.setDate();
			try {
				dateFromBook = format.parse(temp.getDateOfDeliver());
				long difference = dateNow.getTime() - dateFromBook.getTime();
				int days =  (int)(difference / (24 * 60 * 60 * 1000));
				if(days > (month*30)){
					orderByDate.add(temp);
				}
		 } catch (NullPointerException e) {
			 System.out.println("We don't have completed orders");
			 TextLogger.exceptLog(e);
	     } catch (Exception e) {
	    	 TextLogger.exceptLog(e);
	      	}
		}
		return orderByDate;
	}
	

}
