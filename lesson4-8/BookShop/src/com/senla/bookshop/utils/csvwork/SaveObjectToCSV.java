package com.senla.bookshop.utils.csvwork;

import java.io.FileWriter;
import java.util.List;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.managers.BookManager;
import com.senla.bookshop.storage.BookStorage;
import com.senla.bookshop.storage.OrderStorage;
import com.senla.bookshop.storage.RequestStorage;
import com.senla.bookshop.utils.setting.Setting;

public class SaveObjectToCSV {
	
	private static final Logger logger = Logger.getLogger(SaveObjectToCSV.class);
	
	
	private static String NEW_LINE_SEPARATOR = "\n";
	
	private static String FILE_BOOK_HEADER = "id, name, price, status, yearOfPublication, date, countOfRequest";
	private static String FILE_ORDER_HEADER = "id, dateOfDeliver, status, idBook, nameOfBook, price, yearOfPublication";
	private static String FILE_REQUEST_HEADER = "id, idBook, nameOfBook, priceOfBook, yearOfPublication";
	
	private final static String PROPARTY_BOOK_KEY_CSV = "bookPathCSV";
	private final static String PROPARTY_ORDER_KEY_CSV = "orderPathCSV";
	private final static String PROPARTY_REQUEST_KEY_CSV = "requestPathCSV";
	
	
	public static String getFILE_BOOK_HEADER() {
		return FILE_BOOK_HEADER;
	}
	public static String getNEW_LINE_SEPARATOR() {
		return NEW_LINE_SEPARATOR;
	}
	
    public static void bookWriteToCSV(){
    	try(FileWriter fileWriter = new FileWriter(Setting.getPath(PROPARTY_BOOK_KEY_CSV))){
    		String[] arrayBooks = ParseToString.bookToString(BookStorage.getInstance().getBooks());
				fileWriter.append(FILE_BOOK_HEADER);
				fileWriter.append(NEW_LINE_SEPARATOR);
				for(int i = 0; i < arrayBooks.length; i++){
					fileWriter.append(arrayBooks[i]);
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				fileWriter.flush();
		} catch (Exception e ) {
			logger.error(e);
		}
    }
    
    public static void orderWriteToCSV(){
    	try (FileWriter fileWriter = new FileWriter(Setting.getPath(PROPARTY_ORDER_KEY_CSV))){
    		String[] arrayOrders = ParseToString.orderToString(OrderStorage.getInstance().getOrdersBooks());
				fileWriter.append(FILE_ORDER_HEADER);
				fileWriter.append(NEW_LINE_SEPARATOR);
				for(int i = 0; i < arrayOrders.length; i++){
					fileWriter.append(arrayOrders[i]);
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				fileWriter.flush();
		} catch (Exception e) {
			logger.error(e);
		}
    }
    
    public static void requestWriteToCSV(){
    	try (FileWriter fileWriter = new FileWriter(Setting.getPath(PROPARTY_REQUEST_KEY_CSV))){
    		String[] arrayRequest = ParseToString.requestToString(RequestStorage.getInstance().getRequestsBooks());
				fileWriter.append(FILE_REQUEST_HEADER);
				fileWriter.append(NEW_LINE_SEPARATOR);
				for(int i = 0; i < arrayRequest.length; i++){
					fileWriter.append(arrayRequest[i]);
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				fileWriter.flush();
		} catch (Exception e) {
			logger.error(e);
		}
		
    }
	

}
