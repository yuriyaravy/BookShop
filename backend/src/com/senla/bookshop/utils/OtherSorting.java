package backend.src.com.senla.bookshop.utils;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import backend.src.com.senla.bookshop.entities.Book;
import backend.src.com.senla.bookshop.entities.Order;
import backend.src.com.senla.bookshop.storage.OrderStorage;
import backend.src.com.senla.bookshop.utils.exceptions.Setting;

public class OtherSorting {
	
	private static final Logger logger = Logger.getLogger(OtherSorting.class);
	
	
	public static void sortOldBooks (ArrayList<Book> old){
		for(Book temp : old){
			Date dateFromBook = null;
			Date dateNow = DateManager.setDate();
			try {
				dateFromBook = temp.getDate();
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
		ArrayList<Order> order = OrderStorage.getInstance().getOrdersBooks();
		ArrayList<Order> orderByDate = new ArrayList<>();
		for(Order temp : order){
			Date dateFromBook = null;
			Date dateNow = DateManager.setDate();
			try {
				dateFromBook = temp.getDateOfDeliver();
				long difference = dateNow.getTime() - dateFromBook.getTime();
				int days =  (int)(difference / (24 * 60 * 60 * 1000));
				if(days > (month*30)){
					orderByDate.add(temp);
				}
		 } catch (NullPointerException e) {
			 System.out.println("We don't have completed orders");
			 logger.error(e);
	     } catch (Exception e) {
	    	 logger.error(e);
	      	}
		}
		return orderByDate;
	}
	

}
