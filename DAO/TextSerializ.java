package by.home.book.DAO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import by.home.book.base.*;

public class TextSerializ {
	
	private String PATH_BOOK = "src/by/home/book/file/book.txt";
	private String PATH_ORDER = "src/by/home/book/file/order.txt";
	private String PATH_REQUEST = "src/by/home/book/file/request.txt";
	
	private static TextSerializ instance;
	
	private TextSerializ (){
	}
	
	public static TextSerializ getInstance(){
		if(instance == null)
			synchronized (TextSerializ.class){
				if(instance == null)
					instance = new TextSerializ();
			}
		return instance;
	}
	
	public void textBookSerial(ArrayList<Book> books){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_BOOK))){
			oos.writeObject(books);
		}catch(Exception e){
			TextLogger.exceptLog(e);
		}
	}
	
	public void textOrderSerial(ArrayList<Order> orders){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_ORDER))){
			oos.writeObject(orders);
		}catch(Exception e){
			TextLogger.exceptLog(e);
		}
	}
	
	public void textReuqestSerial(ArrayList<Request> request){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_REQUEST))){
			oos.writeObject(request);
		}catch(Exception e){
			TextLogger.exceptLog(e);
		}
	}
	
	
}
