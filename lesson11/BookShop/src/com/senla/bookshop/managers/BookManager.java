package com.senla.bookshop.managers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.senla.bookshop.api.controllers.IBookManager;
import com.senla.bookshop.dao.api.IBookDao;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;

public class BookManager implements IBookManager{
	
	private final IBookDao bookDao = (IBookDao) DependencyIngection.getInctance().getClassInstance(IBookDao.class);
	
	@Override
	public void getAnnotationBook() throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ParseException, SQLException{
		bookDao.create((Book) AnnotationCSVReader.readerFromCsv(Book.class));
	}
	
	@Override
	public Book getBookById(int id){
		return bookDao.getById(id);	}
	@Override
	public List<Book> getBookByName(){
		return bookDao.getBookByName();
	}
	@Override
	public List<Book> getBookByDate(){
		return bookDao.getBookByDate();
	}
	@Override
	public List<Book> getBookByYearOfPublic(){
		return bookDao.getBookByYearOfPublic();
	}
	@Override
	public List<Book> getBookByStatus(){
		return bookDao.getBookByStatus();
	}
	@Override
	public List<Book> getBookByPrice(){
		return bookDao.getBookByPrice();
	}
	@Override
	public List<Book> getBooks(){
		return bookDao.getBooks();
	}

	@Override
	public List<Book> sortOldBooks() {
		List<Book> oldBook = bookDao.getOldBook(); 
		return oldBook;
	}
	
	
}
