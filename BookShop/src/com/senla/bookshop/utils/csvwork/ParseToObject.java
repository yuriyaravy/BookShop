package com.senla.bookshop.utils.csvwork;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.enums.OrderStatus;

public class ParseToObject {
	
	public static List<Book> stringToBook(String [] array) throws ParseException{
		
		List<Book> bookFromCSV = new ArrayList<Book>();
		
			for (int i = 1; i < array.length; i++) {
				String[] cutArray = array[i].split(", ");
				Book csvBook = new Book();
				csvBook.setId(Integer.parseInt(cutArray[0]));
				csvBook.setName(cutArray[1]);
				csvBook.setPrice(Double.parseDouble(cutArray[2]));
				csvBook.setStatus(Boolean.parseBoolean(cutArray[3]));
				csvBook.setYearOfPublication(Integer.parseInt(cutArray[4]));
				DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
				csvBook.setDate(df.parse(cutArray[5]));
				csvBook.setCountOfRequest(Integer.parseInt(cutArray[6]));
				bookFromCSV.add(csvBook);
			}
		return bookFromCSV;
	}
	
	
	public static List<Order> stringToOrder(String [] array) throws ParseException{
		List<Order> orderFromCSV = new ArrayList<Order>();
		List<Book> cutListBooks = new ArrayList<Book>();
		Order csvOrder = new Order();
		
			for (int i = 1; i < array.length; i++) {
				String[] cutArray = array[i].split(", ");
				csvOrder.setId(Integer.parseInt(cutArray[0]));
			
				for (int j = 5; j < array.length; j++) {
					String[] cutBook = array[j].split(",");
					Book csvBook = new Book();
					csvBook.setId(Integer.parseInt(cutBook[0]));
					csvBook.setName(cutBook[1]);
					csvBook.setPrice(Double.parseDouble(cutBook[2]));
					csvBook.setStatus(Boolean.parseBoolean(cutBook[3]));
					csvBook.setYearOfPublication(Integer.parseUnsignedInt(cutBook[4]));
					DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
					csvBook.setDate(df.parse(cutBook[5]));
					csvBook.setCountOfRequest(Integer.parseInt(cutBook[6]));
					cutListBooks.add(csvBook);
				}
			csvOrder.setBook(cutListBooks);	
			if(cutArray[2] == null){
				DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
				csvOrder.setDateOfDeliver(df.parse(cutArray[1]));
			}
			csvOrder.setStatus(OrderStatus.valueOf(cutArray[2]));
			orderFromCSV.add(csvOrder);
		}
		return orderFromCSV;
	}
	
	public static List<Request> stringToRequest(String [] array) throws ParseException{
		List<Request> requestFromCSV = new ArrayList<Request>();
		Book csvBook = new Book();
		String[] cutArray = array[1].split(",");
		Request csvRequest = new Request();
		csvRequest.setId(Integer.parseInt(cutArray[0]));
				
		for (int j = 2; j < array.length; j++) {
			String[] cutBook = array[j].split(",");
			csvBook.setId(Integer.parseInt(cutBook[0]));
			csvBook.setName(cutBook[1]);
			csvBook.setPrice(Double.parseDouble(cutBook[2]));
			csvBook.setStatus(Boolean.parseBoolean(cutBook[3]));
			csvBook.setYearOfPublication(Integer.parseInt(cutBook[4]));
			DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
			csvBook.setDate(df.parse(cutBook[5]));
			csvBook.setCountOfRequest(Integer.parseInt(cutBook[6]));
		}
		csvRequest.setBook(csvBook);
		requestFromCSV.add(csvRequest);
		return requestFromCSV;
	}

}
