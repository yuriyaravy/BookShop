package by.home.book.instruments;

import by.home.book.DAO.TextDeserializ;
import by.home.book.repository.BookManager;
import by.home.book.repository.OrderManager;
import by.home.book.repository.RequestManager;

public class ArrayWorker {
	
	public static void fillUpAllArray(){
		BookManager.books = TextDeserializ.getInstance().textBookDeser();
		OrderManager.orderBooks = TextDeserializ.getInstance().textOrderDeser();
		RequestManager.requestBooks = TextDeserializ.getInstance().textRequestDeser();
	}

}
