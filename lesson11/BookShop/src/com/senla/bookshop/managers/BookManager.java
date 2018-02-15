package com.senla.bookshop.managers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.text.ParseException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.senla.bookshop.api.controllers.IBookManager;
import com.senla.bookshop.dao.api.IBookDao;
import com.senla.bookshop.dao.connect.DataBaseConnect;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;

public class BookManager implements IBookManager{
	
	private final IBookDao bookDao = (IBookDao) DependencyIngection.getInctance().getClassInstance(IBookDao.class);
	private DataBaseConnect dbconnect = DataBaseConnect.getInstance();
	
	@Override
	public void getAnnotationBook() throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ParseException, SQLException{
		bookDao.create((Connection) dbconnect.getConnection(), (Book) AnnotationCSVReader.readerFromCsv(Book.class));
	}
	
	@Override
	public void addBook(Book book){
		Connection connection = (Connection) dbconnect.getConnection();
		Savepoint savepoint = null;
		try{
			connection.setAutoCommit(false);
			savepoint = connection.setSavepoint();
			bookDao.create(connection, book);
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				connection.rollback(savepoint);
			} catch (SQLException e1) {
			}
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
			}
		}
	}
	
	@Override
	public Book getBookById(int id){
		return bookDao.getById((Connection) dbconnect.getConnection(), id);	
	}
	@Override
	public List<Book> getBookByName(){
		return bookDao.getBookByName((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Book> getBookByDate(){
		return bookDao.getBookByDate((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Book> getBookByYearOfPublic(){
		return bookDao.getBookByYearOfPublic((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Book> getBookByStatus(){
		return bookDao.getBookByStatus((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Book> getBookByPrice(){
		return bookDao.getBookByPrice((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Book> getBooks(){
		return bookDao.getBooks((Connection) dbconnect.getConnection());
	}

	@Override
	public List<Book> sortOldBooks() {
		List<Book> oldBook = bookDao.getOldBook((Connection)dbconnect.getConnection()); 
		return oldBook;
	}
	
	
}
