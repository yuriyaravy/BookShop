package com.senla.bookshop.managers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.bookshop.api.controllers.IBookManager;
import com.senla.bookshop.api.storages.IBookStorage;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.storage.BookStorage;
import com.senla.bookshop.utils.csvwork.ParseToObject;
import com.senla.bookshop.utils.csvwork.ReadFromCSV;
import com.senla.bookshop.utils.csvwork.SaveObjectToCSV;
import com.senla.bookshop.utils.setting.Setting;
import com.senla.bookshop.utils.txtwork.TextSerializ;

public class BookManager implements IBookManager{
	
	private final IBookStorage bookStorage = BookStorage.getInstance();
	
	private static final Logger logger = Logger.getLogger(BookManager.class);
	
	private final String PROPARTY_KEY = "bookPath";
	
	private final String PROPARTY_KEY_CSV = "bookPathCSV";
	
	@Override
	public Book getBookById(int id){
		return bookStorage.getBookById(id);
	}
	@Override
	public List<Book> getBook(Comparator<Book> comparator){
		return bookStorage.getSortBook(comparator);
	}
	@Override
	public void saveBookToCSV(){
		SaveObjectToCSV.bookWriteToCSV();
	}
	@Override
	public void readBookFromCSV() throws ParseException{
		List<Book> csvBooks = ParseToObject.stringToBook(ReadFromCSV.readCSV(PROPARTY_KEY_CSV));
		Book newBook = null;
		for(Book tempCSV : csvBooks){
			for(int i = 0; i < bookStorage.getBooks().size(); i++){
				if(tempCSV.getId() != bookStorage.getBooks().get(i).getId()){
					newBook = tempCSV;
				}
			}
			bookStorage.addBook(newBook);
		}
	}
	
	@Override
	public List<Book> getBooks(){
		return bookStorage.getBooks();
	}
	@Override
	public void serializationForBooks(){
		TextSerializ.textSerialize(BookStorage.getInstance().getBooks(), PROPARTY_KEY);
	}
	@Override
	public void fillUpBookStorage(){
		bookStorage.fillUpBookStorage(PROPARTY_KEY);
	}
	
}
