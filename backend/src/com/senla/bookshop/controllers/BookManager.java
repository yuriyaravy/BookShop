package backend.src.com.senla.bookshop.controllers;

import java.util.ArrayList;
import java.util.Comparator;

import org.apache.log4j.Logger;

import backend.src.com.senla.bookshop.api.controllers.IBookManager;
import backend.src.com.senla.bookshop.entities.Book;
import backend.src.com.senla.bookshop.storage.BookStorage;
import backend.src.com.senla.bookshop.utils.csvworker.PathStorage;
import backend.src.com.senla.bookshop.utils.csvworker.ReadFromCSV;
import backend.src.com.senla.bookshop.utils.csvworker.SaveObjectToCSV;
import backend.src.com.senla.bookshop.utils.txtworker.TextSerializ;

public class BookManager implements IBookManager{
	
	private static final Logger logger = Logger.getLogger(BookManager.class);
	
	@Override
	public Book getBookById(int id){
		Book current  = null;
		for(Book temp : BookStorage.getInstance().getBooks()) {
			if(temp.getId() == id){
				current = temp;
				break;
			}
		}
		return current;
	}
	@Override
	public ArrayList<Book> getBook(Comparator<Book> comparator){
		return BookStorage.getInstance().getSortBook(comparator);
	}
	@Override
	public void saveBookToCSV(int id){
		SaveObjectToCSV.bookWriteToCSV(id);
	}
	@Override
	public ArrayList<String> readBookFromCSV(){
		return ReadFromCSV.readCSV(new PathStorage().getCsvBookFile());
	}
	@Override
	public ArrayList<Book> getBooks(){
		return BookStorage.getInstance().getBooks();
	}
	@Override
	public void serializationForBooks(){
		TextSerializ.getInstance().textBookSerial(BookStorage.getInstance().getBooks());
	}
}
