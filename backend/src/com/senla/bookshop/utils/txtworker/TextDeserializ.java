package backend.src.com.senla.bookshop.utils.txtworker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import backend.src.com.senla.bookshop.entities.Book;
import backend.src.com.senla.bookshop.entities.Order;
import backend.src.com.senla.bookshop.entities.Request;


public class TextDeserializ {
	
	private static final Logger logger = Logger.getLogger(TextDeserializ.class);
	
	private String PATH_BOOK = "E:/WorkSpace/BookShop/src/file/com/senla/bookshop/files/book.txt";
	private String PATH_ORDER = "/BookShop/src/file/com/senla/bookshop/files/order.txt";
	private String PATH_REQUEST = "/BookShop/src/file/com/senla/bookshop/files/request.txt";
	
	private static TextDeserializ instance;
	
	private TextDeserializ (){
	}
	
	public static TextDeserializ getInstance(){
		if(instance == null)
			synchronized (TextDeserializ.class){
				if(instance == null)
					instance = new TextDeserializ();
			}
		return instance;
	}
	
	public ArrayList<Book> textBookDeser(){
		ArrayList<Book> books = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_BOOK))){
			books = (ArrayList<Book>) ois.readObject();
		} catch (ClassNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		return books;
	}
	
	public ArrayList<Order> textOrderDeser(){
		ArrayList<Order> orders = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_ORDER));
			orders = (ArrayList<Order>) ois.readObject();
		} catch (ClassNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		return orders;
	}
	
	public ArrayList<Request> textRequestDeser(){
		ArrayList<Request> requests = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_REQUEST));
			requests = (ArrayList<Request>) ois.readObject();
		} catch (ClassNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		return requests;
	}
	
	
}
