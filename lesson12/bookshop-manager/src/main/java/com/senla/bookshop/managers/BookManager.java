package com.senla.bookshop.managers;

import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.senla.bookshop.api.controllers.IBookManager;
import com.senla.bookshop.api.dao.IBookDao;
import com.senla.bookshop.dao.connect.DataBaseConnect;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.hibernate.Book;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;

public class BookManager implements IBookManager{
	
	private static final Logger logger = LogManager.getLogger(BookManager.class);
	
	private final IBookDao bookDao = (IBookDao) DependencyIngection.getInctance().getClassInstance(IBookDao.class);
	private DataBaseConnect dbconnect = DataBaseConnect.getInstance();
	
	@Override
	public void getAnnotationBook() throws Exception{
		bookDao.create((Connection) dbconnect.getConnection(), (Book) AnnotationCSVReader.readerFromCsv(Book.class));
	}
	
	@Override
	public void addBook(Book book) throws Exception{
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
				logger.error(e1);
			}
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
	
	@Override
	public Book getBookById(int id) throws Exception{
		return bookDao.getById((Connection) dbconnect.getConnection(), id);	
	}
	@Override
	public List<Book> getBookByName() throws Exception{
		return bookDao.getBookByName((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Book> getBookByDate() throws Exception{
		return bookDao.getBookByDate((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Book> getBookByYearOfPublic() throws Exception{
		return bookDao.getBookByYearOfPublic((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Book> getBookByStatus() throws Exception{
		return bookDao.getBookByStatus((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Book> getBookByPrice() throws Exception{
		return bookDao.getBookByPrice((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Book> getBooks() throws Exception{
		return bookDao.getBooks((Connection) dbconnect.getConnection());
	}

	@Override
	public List<Book> sortOldBooks() throws Exception {
		List<Book> oldBook = bookDao.getOldBook((Connection)dbconnect.getConnection()); 
		return oldBook;
	}
	
	
}
