package by.home.book.services.comparators.order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import by.home.book.DAO.TextLogger;
import by.home.book.base.Order;

public class ComparatorOrderByDate implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		if(o1 != null && o2 != null){
			SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
	        Date o1PublishDate = null;
	        Date o2PublishDate = null;
	        try {
	            o1PublishDate = formatter.parse(o1.getDateOfDeliver());
	            o2PublishDate = formatter.parse(o2.getDateOfDeliver());
	        } catch (ParseException pe) {
	        	  TextLogger.exceptLog(pe);
	        }
	        return o1PublishDate.compareTo(o2PublishDate);
		}else{
			return 0;
		}
	}

}
