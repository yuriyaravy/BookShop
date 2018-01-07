package by.home.book.base;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;

import by.home.book.DAO.TextDeserializ;
import by.home.book.DAO.TextSerializ;
import by.home.book.DAO.CSV.ReadFromCSV;
import by.home.book.DAO.CSV.SaveObjectToCSV;
import by.home.book.fasade.action.order.clone.CloneOrder;
import by.home.book.fasade.action.order.work.AddOrder;
import by.home.book.fasade.action.other.SaveBookChanges;
import by.home.book.instruments.Id;
import by.home.book.repository.BookManager;
import by.home.book.repository.OrderManager;
import by.home.book.repository.RequestManager;
import by.home.book.services.OtherSorting;
import by.home.book.services.comparators.book.ComparatorBookByPrice;
import by.home.book.services.comparators.order.ComparatorOrderByPrice;


public class Main {
	

	public static void main(String[] args) {
		orderList();
		OrderManager.orderCompleate(1);
		for(Order x : OrderManager.orderBooks){
			System.out.println(x);
		}
		
		}
	
	public static void booklist(){
		BookManager.books.add(new Book(1, "Azbyka", 245, 2006, false , "01.12.2017"));
		BookManager.books.add(new Book(2, "Gore ot yma", 235, 1824, true, "13.10.2017"));
		BookManager.books.add(new Book(3, "Master i margarita", 305, 1937, true, "23.12.2014"));
		BookManager.books.add(new Book(4, "Voina i mir",  600, 1869, true, "05.12.2007"));
		BookManager.books.add(new Book(5, "Idiot",  250.0, 1868 , false, "15.02.2017"));
		BookManager.books.add(new Book(6 , "Coloring book",  100 , 2015, true, "23.10.2017"));
		BookManager.books.add(new Book(7 , "ABC",  149 , 2000 , false, "13.03.2017"));
		BookManager.books.add(new Book(8, "Romeo and Juliet",  505 , 1597, false, "23.12.2000"));
		BookManager.books.add(new Book(9, "Don Quixote", 750 , 1875, false, "23.12.2007"));
		BookManager.books.add(new Book(10, "Game of Thrones",  625 , 1997, false, "01.11.2011"));
		BookManager.books.add(new Book(11, "Voina i mir",  600, 1869, true, "04.09.2010"));
		BookManager.books.add(new Book(12, "Idiot",  250.0, 1868 , false, "15.07.2017"));
		BookManager.books.add(new Book(13, "Programming book",  1230 , 2015, true, "18.12.2013"));
	}
	
	public static void orderList(){
		OrderManager.orderBooks.add(new Order(1, new int []{7,2}, OrderStatus.PROCESSING));
		OrderManager.orderBooks.add(new Order(2, new int []{6,5,3}, OrderStatus.COMPLEATE));
		OrderManager.orderBooks.add(new Order(3, new int []{11,10}, OrderStatus.PROCESSING));
		OrderManager.orderBooks.add(new Order(4, new int []{8}, OrderStatus.PROCESSING));
	}
	public static void requestList(){
		RequestManager.requestBooks.add(new Request(1, (new Book(18, "HAPPY NEW YEAR",  2018 , 2018, true, "31.12.2017"))));
		RequestManager.requestBooks.add(new Request(2, (new Book(19, "say no hangovers ))",  10, 1869, true, "04.09.2012"))));
	}

}
