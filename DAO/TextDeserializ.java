package by.home.book.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import by.home.book.base.Book;
import by.home.book.base.Order;
import by.home.book.base.Request;


public class TextDeserializ {
	
	private String PATH_BOOK = "src/by/home/book/file/book.txt";
	private String PATH_ORDER = "src/by/home/book/file/order.txt";
	private String PATH_REQUEST = "src/by/home/book/file/request.txt";
	
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
			TextLogger.exceptLog(e);
		} catch (IOException e) {
			TextLogger.exceptLog(e);
		}
		return books;
	}
	
	public ArrayList<Order> textOrderDeser(){
		ArrayList<Order> orders = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_ORDER));
			orders = (ArrayList<Order>) ois.readObject();
		} catch (ClassNotFoundException e) {
			TextLogger.exceptLog(e);
		} catch (IOException e) {
			TextLogger.exceptLog(e);
		}
		return orders;
	}
	
	public ArrayList<Request> textRequestDeser(){
		ArrayList<Request> requests = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_REQUEST));
			requests = (ArrayList<Request>) ois.readObject();
		} catch (ClassNotFoundException e) {
			TextLogger.exceptLog(e);
		} catch (IOException e) {
			TextLogger.exceptLog(e);
		}
		return requests;
	}
	
	
}
