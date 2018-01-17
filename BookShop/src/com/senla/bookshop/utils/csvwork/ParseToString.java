package com.senla.bookshop.utils.csvwork;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;

public class ParseToString {
	
	private static final String COMMA_DELIMITER = ", ";
	
	public static String[] bookToString(List<Book> bookList){
		String[] stringBooks = new String[bookList.size()];
		
		for(int i = 0; i < bookList.size(); i++){
			Book bookFromList = bookList.get(i);
			StringBuilder str = new StringBuilder();
			
			str.append(String.valueOf(bookFromList.getId()));
			str.append(COMMA_DELIMITER);
			str.append(bookFromList.getName());
			str.append(COMMA_DELIMITER);
			str.append(String.valueOf(bookFromList.getPrice()));
			str.append(COMMA_DELIMITER);
			str.append(String.valueOf(bookFromList.isStatus()));
			str.append(COMMA_DELIMITER);
			str.append(String.valueOf(bookFromList.getYearOfPublication()));
			str.append(COMMA_DELIMITER);
			str.append(String.valueOf(bookFromList.getDate()));
			str.append(COMMA_DELIMITER);
			str.append(String.valueOf(bookFromList.getCountOfRequest()));
			str.append(COMMA_DELIMITER);
			stringBooks[i] = str.toString();
		}
		return stringBooks;
	}
	
	public static String[] orderToString(List<Order> orderList){
		String[] stringOrders = new String[orderList.size()];
		
		for(int i = 0; i < orderList.size(); i++){
			Order orderFromList = orderList.get(i);
			StringBuilder str = new StringBuilder();
			
			str.append(String.valueOf(orderFromList.getId()));
			str.append(COMMA_DELIMITER);
			str.append(SaveObjectToCSV.getNEW_LINE_SEPARATOR());
			
			if(orderFromList.getBook() != null){
				List<Book> orderBooks = orderFromList.getBook();
				String[] orderBooksArray = new String[orderBooks.size()];
				orderBooksArray = bookToString(orderBooks);
				str.append(SaveObjectToCSV.getFILE_BOOK_HEADER());
				str.append(SaveObjectToCSV.getNEW_LINE_SEPARATOR());
				for(int j = 0; j < orderBooksArray.length; j++){
					str.append(orderBooksArray[j]);
					str.append(SaveObjectToCSV.getNEW_LINE_SEPARATOR());
				}
			}
			str.append(COMMA_DELIMITER);
			str.append(String.valueOf(orderFromList.getDateOfDeliver()));
			str.append(COMMA_DELIMITER);
			str.append(String.valueOf(orderFromList.getStatus()));
			str.append(COMMA_DELIMITER);
			stringOrders[i] = str.toString();
		}
		return stringOrders;
	}
	
	public static String[] requestToString(List<Request> requestList){
		String[] stringRequest = new String[requestList.size()];
		
		for(int i = 0; i < requestList.size(); i++){
			Request requestFromList = requestList.get(i);
			StringBuilder str = new StringBuilder();
			
			str.append(String.valueOf(requestFromList.getId()));
			str.append(COMMA_DELIMITER);
			str.append(SaveObjectToCSV.getNEW_LINE_SEPARATOR());
			
			if(requestFromList.getBook() != null){
				List<Book> books = new ArrayList<Book>();
				books.add(requestFromList.getBook());
				String[] requestBooksArray = new String[books.size()];
				requestBooksArray = bookToString(books);
				str.append(SaveObjectToCSV.getFILE_BOOK_HEADER());
				str.append(SaveObjectToCSV.getNEW_LINE_SEPARATOR());
				for(int j = 0; j < requestBooksArray.length; j++){
					str.append(requestBooksArray[j]);
					str.append(SaveObjectToCSV.getNEW_LINE_SEPARATOR());
				}
			}
			stringRequest[i] = str.toString();
		}
		return stringRequest;
	}

}
