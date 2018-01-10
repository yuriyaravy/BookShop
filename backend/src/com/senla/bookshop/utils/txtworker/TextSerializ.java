package backend.src.com.senla.bookshop.utils.txtworker;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import backend.src.com.senla.bookshop.entities.Book;
import backend.src.com.senla.bookshop.entities.Order;
import backend.src.com.senla.bookshop.entities.Request;


public class TextSerializ {
	
	private static final Logger logger = Logger.getLogger(TextSerializ.class);
	
	private String PATH_BOOK = "E:/WorkSpace/BookShop/src/file/com/senla/bookshop/files/book.txt";
	private String PATH_ORDER = "/BookShop/src/file/com/senla/bookshop/files/order.txt";
	private String PATH_REQUEST = "/BookShop/src/file/com/senla/bookshop/files/request.txt";
	
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
			logger.error(e);
		}
	}
	
	public void textOrderSerial(ArrayList<Order> orders){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_ORDER))){
			oos.writeObject(orders);
		}catch(Exception e){
			logger.error(e);
		}
	}
	
	public void textReuqestSerial(ArrayList<Request> request){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_REQUEST))){
			oos.writeObject(request);
		}catch(Exception e){
			logger.error(e);
		}
	}
	
	
}
