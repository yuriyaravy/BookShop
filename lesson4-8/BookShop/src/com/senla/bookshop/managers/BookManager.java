package com.senla.bookshop.managers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.bookshop.api.controllers.IBookManager;
import com.senla.bookshop.api.storages.IBookStorage;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.storage.BookStorage;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;
import com.senla.bookshop.utils.csvwork.ParseToObject;
import com.senla.bookshop.utils.csvwork.ReadFromCSV;
import com.senla.bookshop.utils.csvwork.SaveObjectToCSV;
import com.senla.bookshop.utils.setting.Setting;
import com.senla.bookshop.utils.txtwork.TextSerializ;

public class BookManager implements IBookManager{
	
	private final IBookStorage bookStorage = (IBookStorage) DependencyIngection.getInctance().getClassInstance(IBookStorage.class);
	
	private static final Logger logger = Logger.getLogger(BookManager.class);
	
	private final String PROPARTY_KEY = "bookPath";
	
	private final String PROPARTY_KEY_CSV = "bookPathCSV";
	
	@SuppressWarnings("unchecked")
	@Override
	public void getAnnotationBook() throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ParseException{
		bookStorage.setBooks((List<Book>) AnnotationCSVReader.readerFromCsv(Book.class));
	}
	
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
		int booksSize = bookStorage.getBooks().size();
		for(Book tempCSV : csvBooks){
			if(bookStorage.getBooks().size()>0){
				for(int i = 0; i < booksSize; i++){
					if(tempCSV.getId() != bookStorage.getBooks().get(i).getId()){
						bookStorage.addBook(tempCSV);
					}
				}
			}
			bookStorage.addBook(tempCSV);
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
