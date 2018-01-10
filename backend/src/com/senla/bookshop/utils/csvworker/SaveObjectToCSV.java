package backend.src.com.senla.bookshop.utils.csvworker;

import java.io.FileWriter;
import java.util.Arrays;

import org.apache.log4j.Logger;

import backend.src.com.senla.bookshop.controllers.BookManager;
import backend.src.com.senla.bookshop.entities.Book;
import backend.src.com.senla.bookshop.entities.Order;
import backend.src.com.senla.bookshop.entities.Request;
import backend.src.com.senla.bookshop.facade.Facade;

public class SaveObjectToCSV {
	
	private static final Logger logger = Logger.getLogger(SaveObjectToCSV.class);
	
	
	private static String COMMA_DELIMITER = ", ";
	private static String NEW_LINE_SEPARATOR = "\n";
	
	private static String FILE_BOOK_HEADER = "id, name, price, status, yearOfPublication, date, countOfRequest.";
	private static String FILE_ORDER_HEADER = "id, bookId, dateOfDeliver, status.";
	private static String FILE_REQUEST_HEADER = "id, book.";
	
    public static void bookWriteToCSV(int id){
    	try{
    		Book book = new BookManager().getBookById(id);
			FileWriter fileWriter = new FileWriter(new PathStorage().getCsvBookFile());
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
    	try {
    		Order order = Facade.getInstance().getOrderById(id);
			FileWriter fileWriter = new FileWriter(new PathStorage().getCsvOrderFile());
			fileWriter.append(FILE_ORDER_HEADER);
				fileWriter.append(NEW_LINE_SEPARATOR);
				fileWriter.append(String.valueOf(order.getId()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(Arrays.toString(order.getBookId())));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(order.getDateOfDeliver()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(order.getStatus()));
				fileWriter.flush();
				fileWriter.close();
		} catch (Exception e) {
			logger.error(e);
		}
    }
    
    public static void requestWriteToCSV(int id){
    	try {
    		Request request = Facade.getInstance().getRequestById(id);
    		System.out.println(request);
			FileWriter fileWriter = new FileWriter(new PathStorage().getCsvRequestFile());
			fileWriter.append(FILE_REQUEST_HEADER);
				fileWriter.append(NEW_LINE_SEPARATOR);
				fileWriter.append(String.valueOf(request.getId()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(request.getBook()));
				fileWriter.flush();
		
				fileWriter.close();
		} catch (Exception e) {
			logger.error(e);
		}
		
    }
	

}
