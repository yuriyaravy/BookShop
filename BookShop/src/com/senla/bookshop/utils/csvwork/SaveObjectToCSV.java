package com.senla.bookshop.utils.csvwork;

import java.io.FileWriter;
import java.util.List;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;

import com.senla.bookshop.controllers.BookManager;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.setting.Setting;

public class SaveObjectToCSV {
	
	private static final Logger logger = Logger.getLogger(SaveObjectToCSV.class);
	
	
	private static String COMMA_DELIMITER = ", ";
	private static String NEW_LINE_SEPARATOR = "\n";
	private static String SPACE_SEPARATOR = "\t";
	
	private static String FILE_BOOK_HEADER = "id, name, price, status, yearOfPublication, date, countOfRequest";
	private static String FILE_ORDER_HEADER = "id, books, dateOfDeliver, status";
	private static String FILE_REQUEST_HEADER = "id, book";
	
	private final static String PROPARTY_BOOK_KEY_CSV = "bookPathCSV";
	private final static String PROPARTY_ORDER_KEY_CSV = "orderPathCSV";
	private final static String PROPARTY_REQUEST_KEY_CSV = "requestPathCSV";
	
	
    public static void bookWriteToCSV(int id){
    	try(FileWriter fileWriter = new FileWriter(Setting.getPath(PROPARTY_BOOK_KEY_CSV))){
    		Book book = new BookManager().getBookById(id);
				fileWriter.append(FILE_BOOK_HEADER);
				fileWriter.append(NEW_LINE_SEPARATOR);
				fileWriter.append(String.valueOf(book.getId()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(book.getName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(book.getPrice()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(book.isStatus()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(book.getYearOfPublication()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(book.getDate()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(book.getCountOfRequest()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(NEW_LINE_SEPARATOR);
				fileWriter.flush();
				fileWriter.close();
		} catch (Exception e ) {
			logger.error(e);
		}
    }
    
    public static void orderWriteToCSV(int id){
    	try (FileWriter fileWriter = new FileWriter(Setting.getPath(PROPARTY_ORDER_KEY_CSV))){
    		Order order = Facade.getInstance().getOrderById(id);
				fileWriter.append(FILE_ORDER_HEADER);
				fileWriter.append(NEW_LINE_SEPARATOR);
				fileWriter.append(String.valueOf(order.getId()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(order.getDateOfDeliver()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(order.getStatus()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(NEW_LINE_SEPARATOR);
				for(Book temp : order.getBook()){
					fileWriter.append(String.valueOf(temp.getId()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(temp.getName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(temp.getPrice()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(temp.isStatus()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(temp.getYearOfPublication()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(temp.getDate()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(temp.getCountOfRequest()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				
				fileWriter.flush();
		} catch (Exception e) {
			logger.error(e);
		}
    }
    
    public static void requestWriteToCSV(int id){
    	try (FileWriter fileWriter = new FileWriter(Setting.getPath(PROPARTY_REQUEST_KEY_CSV))){
    		Request request = Facade.getInstance().getRequestById(id);
				fileWriter.append(FILE_REQUEST_HEADER);
				fileWriter.append(NEW_LINE_SEPARATOR);
				fileWriter.append(String.valueOf(request.getId()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(NEW_LINE_SEPARATOR);
				Book temp = request.getBook();
					fileWriter.append(String.valueOf(temp.getId()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(temp.getName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(temp.getPrice()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(temp.isStatus()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(temp.getYearOfPublication()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(temp.getDate()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(temp.getCountOfRequest()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(NEW_LINE_SEPARATOR);
				fileWriter.flush();
		} catch (Exception e) {
			logger.error(e);
		}
		
    }
	

}
