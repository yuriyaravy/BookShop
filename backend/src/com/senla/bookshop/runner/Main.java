package backend.src.com.senla.bookshop.runner;

import org.apache.log4j.Logger;

import backend.src.com.senla.bookshop.controllers.OrderManager;
import backend.src.com.senla.bookshop.entities.Book;
import backend.src.com.senla.bookshop.entities.Order;
import backend.src.com.senla.bookshop.entities.Request;
import backend.src.com.senla.bookshop.enums.OrderStatus;
import backend.src.com.senla.bookshop.storage.BookStorage;
import backend.src.com.senla.bookshop.storage.OrderStorage;
import backend.src.com.senla.bookshop.storage.RequestStorage;

public class Main {
	private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		
	}
	public static void booklist(){
		BookStorage.getInstance().addBook(new Book(1, "Azbyka", 245, 2006, false));
		BookStorage.getInstance().addBook(new Book(2, "Gore ot yma", 235, 1824, true));
		BookStorage.getInstance().addBook(new Book(3, "Master i margarita", 305, 1937, true));
		BookStorage.getInstance().addBook(new Book(4, "Voina i mir",  600, 1869, true));
		BookStorage.getInstance().addBook(new Book(5, "Idiot",  250.0, 1868 , false));
		BookStorage.getInstance().addBook(new Book(6 , "Coloring book",  100 , 2015, true));
		BookStorage.getInstance().addBook(new Book(7 , "ABC",  149 , 2000 , false));
		BookStorage.getInstance().addBook(new Book(8, "Romeo and Juliet",  505 , 1597, false));
		BookStorage.getInstance().addBook(new Book(9, "Don Quixote", 750 , 1875, false));
		BookStorage.getInstance().addBook(new Book(10, "Game of Thrones",  625 , 1997, true));
		BookStorage.getInstance().addBook(new Book(11, "Voina i mir",  600, 1869, true));
		BookStorage.getInstance().addBook(new Book(12, "Idiot",  250.0, 1868 , false));
		BookStorage.getInstance().addBook(new Book(13, "Programming book",  1230 , 2015, true));
	}
	
	public static void orderList(){
		OrderStorage.getInstance().addOrders(new Order(1, new int []{7,2}, OrderStatus.PROCESSING));
		OrderStorage.getInstance().addOrders(new Order(2, new int []{6,5,3}, OrderStatus.COMPLEATE));
		OrderStorage.getInstance().addOrders(new Order(3, new int []{11,10}, OrderStatus.PROCESSING));
		OrderStorage.getInstance().addOrders(new Order(4, new int []{8}, OrderStatus.PROCESSING));
	}
	public static void requestList(){
		RequestStorage.getInstance().addRequestBooks(new Request(new Book(18, "HAPPY NEW YEAR",  2018 , 2018, true)));
		RequestStorage.getInstance().addRequestBooks(new Request(new Book(19, "say no hangovers ))",  10, 1869, true)));
	}

}
