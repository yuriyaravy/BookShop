package backend.src.com.senla.bookshop.controllers;

import org.apache.log4j.Logger;

import backend.src.com.senla.bookshop.api.controllers.IBookManager;
import backend.src.com.senla.bookshop.entities.Book;
import backend.src.com.senla.bookshop.storage.BookStorage;

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
	
	
}
