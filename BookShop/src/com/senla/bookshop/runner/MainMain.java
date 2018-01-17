package com.senla.bookshop.runner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.enums.OrderStatus;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.managers.BookManager;
import com.senla.bookshop.storage.BookStorage;
import com.senla.bookshop.storage.OrderStorage;
import com.senla.bookshop.storage.RequestStorage;
import com.senla.bookshop.utils.csvwork.ParseToObject;
import com.senla.bookshop.utils.csvwork.ReadFromCSV;
import com.senla.bookshop.utils.csvwork.SaveObjectToCSV;

public class MainMain {

	public static void main(String[] args) throws ParseException {
		MainMain mm = new MainMain();
	//	mm.booklist();
		Facade.getInstance().fillUpStorages();
		Facade.getInstance().saveRequestToCSV();
		System.out.println(Facade.getInstance().readRequestFromCSV());
	}
	
	public void booklist(){
		BookStorage.getInstance().addBook(new Book(1, "Azbyka", 245.0, 2006, false));
		BookStorage.getInstance().addBook(new Book(2, "Gore ot yma", 235.0, 1824, true));
		BookStorage.getInstance().addBook(new Book(3, "Master i margarita", 305.10, 1937, true));
		BookStorage.getInstance().addBook(new Book(4, "Voina i mir",  600.15, 1869, true));
		BookStorage.getInstance().addBook(new Book(5, "Idiot",  250.0, 1868 , false));
		BookStorage.getInstance().addBook(new Book(6 , "Coloring book",  100.80 , 2015, true));
		BookStorage.getInstance().addBook(new Book(7 , "ABC",  149.99 , 2000 , false));
		BookStorage.getInstance().addBook(new Book(8, "Romeo and Juliet",  505.70 , 1597, false));
		BookStorage.getInstance().addBook(new Book(9, "Don Quixote", 750.15 , 1875, false));
		BookStorage.getInstance().addBook(new Book(10, "Game of Thrones",  625.70 , 1997, true));
		BookStorage.getInstance().addBook(new Book(201, "Voina i mir",  600.90, 1869, true));
		BookStorage.getInstance().addBook(new Book(12, "Idiot",  250.0, 1868 , false));
		BookStorage.getInstance().addBook(new Book(13, "Programming book",  1230.0 , 2015, true));
	}
	
	@SuppressWarnings("unchecked")
	public static void orderList(){
		List<Book> ordBook1 = new ArrayList<Book>();
			ordBook1.add(new Book(1, "Azbyka", 245.0, 2006, false));
			ordBook1.add(new Book(3, "Master i margarita", 305.10, 1937, true));
		OrderStorage.getInstance().addOrders(new Order(1, ordBook1, null , OrderStatus.PROCESSING));
		List<Book> ordBook = new ArrayList<Book>();
			ordBook.add(new Book(5, "Idiot",  250.0, 1868, false));
			ordBook.add(new Book(13, "Programming book",  1230.0, 2015, true));
			ordBook.add(new Book(9, "Don Quixote", 750.15, 1875, false));
		OrderStorage.getInstance().addOrders(new Order(3, ordBook, null , OrderStatus.PROCESSING));
		List<Book> ordBook2 = new ArrayList<Book>();
			ordBook2.add(new Book(6, "Coloring book",  100.80, 2015, true));
		OrderStorage.getInstance().addOrders(new Order(4, ordBook2, null , OrderStatus.PROCESSING));
	}
	public static void requestList(){
		RequestStorage.getInstance().addRequestBooks(new Request(new Book(18, "HAPPY NEW YEAR",  2018.01, 2018, true)));
		RequestStorage.getInstance().addRequestBooks(new Request(new Book(19, "say no hangovers ))",  10.10, 1869, true)));
	}


}
