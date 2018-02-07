package com.senla.bookshop.utils.csvwork;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
				csvBook.setYearOfPublication(Integer.parseInt(cutArray[4].trim()));
				DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
				csvBook.setDate(df.parse(cutArray[5].trim()));
				csvBook.setCountOfRequest(Integer.parseInt(cutArray[6]));
				bookFromCSV.add(csvBook);
			}
		return bookFromCSV;
	}
	
	
	public static List<Order> stringToOrder(String [] array) throws ParseException{
		List<Order> orderFromCSV = new ArrayList<Order>();
		
			for (int i = 1; i < array.length; i++) {
				List<Book> cutListBooks = new ArrayList<Book>();
				Order csvOrder = new Order();
				Book book = new Book();
				String[] cutArray = array[i].split(", ");
				csvOrder.setId(Integer.parseInt(cutArray[0]));
					if(cutArray[1] == null){
						DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
						csvOrder.setDateOfDeliver(df.parse(cutArray[1]));
					}else{
						csvOrder.setDateOfDeliver(null);
					}
					if(cutArray[2].toUpperCase().equals("COMPLEATE")){
						csvOrder.setStatus(OrderStatus.COMPLEATE);
					}else if(cutArray[2].toUpperCase().equals("CANCELED")){
						csvOrder.setStatus(OrderStatus.CANCELED);
					}else{
						csvOrder.setStatus(OrderStatus.PROCESSING);
					}
						book.setId(Integer.parseInt(cutArray[3]));
						book.setName(cutArray[4]);
						book.setPrice(Double.parseDouble(cutArray[5]));
						book.setYearOfPublication(Integer.parseInt(cutArray[6]));
						book.setDate(new Date());
						cutListBooks.add(book);
				csvOrder.setBook(cutListBooks);
				orderFromCSV.add(csvOrder);
		}
		return orderFromCSV;
	}
	
	public static List<Request> stringToRequest(String [] array) throws ParseException{
		List<Request> requestFromCSV = new ArrayList<Request>();
		
		for (int i = 1; i < array.length; i++){
			Request csvRequest = new Request();
			String[] cutArray = array[i].split(", ");
			System.out.println(array[i]);
			Book csvBook = new Book();
			csvRequest.setId(Integer.parseInt(cutArray[0]));
			csvBook.setId(Integer.parseInt(cutArray[1]));
			csvBook.setName(cutArray[2]);
			csvBook.setPrice(Double.parseDouble(cutArray[3]));
			csvBook.setYearOfPublication(Integer.parseInt(cutArray[4]));
			csvBook.setDate(new Date());
			csvRequest.setBook(csvBook);
			requestFromCSV.add(csvRequest);
			
		}
		return requestFromCSV;
	}

}
