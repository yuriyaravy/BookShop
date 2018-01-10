package backend.src.com.senla.bookshop.utils;

import backend.src.com.senla.bookshop.storage.BookStorage;
import backend.src.com.senla.bookshop.storage.OrderStorage;
import backend.src.com.senla.bookshop.storage.RequestStorage;
import backend.src.com.senla.bookshop.utils.txtworker.TextDeserializ;

public class ArrayWorker {
	
	public static void fillUpAllArray(){
		
		BookStorage.getInstance().setBooks(TextDeserializ.getInstance().textBookDeser()); 
		OrderStorage.getInstance().setOrderBooks(TextDeserializ.getInstance().textOrderDeser());
		RequestStorage.getInstance().setRequestsBooks(TextDeserializ.getInstance().textRequestDeser());
	}

}
