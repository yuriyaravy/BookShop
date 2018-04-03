package com.senla.bookshop.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.bookshop.api.controller.IBookManager;
import com.senla.bookshop.api.dao.IBookDao;
import com.senla.bookshop.entity.Book;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;

@Service("bookManager")
@Transactional
public class BookManager implements IBookManager{
	
	private static final Logger LOGGER = LogManager.getLogger(BookManager.class);
	
	@Autowired
	private IBookDao bookDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void getAnnotationBook() throws Exception{
		bookDao.create((Session) sessionFactory.openSession(), (Book) AnnotationCSVReader.readerFromCsv(Book.class));
	}
	
	@Transactional
	public void addBook(Book book) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		try{
			bookDao.create(session, book);
		} catch (HibernateException  e) {
			LOGGER.error(e);
		} 
	}
	
	@Transactional
	public Book getBookById(int id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Book book = null;
		try{
			book = bookDao.getById(session, id);
			return book;
		} catch (HibernateException  e) {
			LOGGER.error(e);
			return null;
		}
	}
	
	@Transactional
	public List<Book> getBookByName() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = null;
		try{
			books = bookDao.sortBookByName(session);
			return books;
		} catch (HibernateException  e) {
			LOGGER.error(e);
			return null;
		}
	}
	
	@Transactional
	public List<Book> getBookByDate() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = null;
		try{
			books = bookDao.sortBookByDate(session);
			return books;
		} catch (HibernateException  e) {
			LOGGER.error(e);
			return null;
		} 
	}
	
	@Transactional
	public List<Book> getBookByYearOfPublic() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = null;
		try{
			books = bookDao.sortBookByYearOfPublic(session);
			return books;
		} catch (HibernateException  e) {
			LOGGER.error(e);
			return null;
		} 
	}
	
	@Transactional
	public List<Book> getBookByStatus() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = null;
		try{
			books = bookDao.sortBookByStatus(session);
			return books;
		} catch (HibernateException  e) {
			LOGGER.error(e);
			return null;
		} 
	}
	
	@Transactional
	public List<Book> getBookByPrice() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = null;
		try{
			books = bookDao.sortBookByPrice(session);
			return books;
		} catch (HibernateException  e) {
				LOGGER.error(e);
			return null;
		} 
	}
	
	@Transactional
	public List<Book> sortOldBooks() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = null;
		try{
			books = bookDao.getOldBook(session); 
			return books;
		} catch (HibernateException  e) {
			LOGGER.error(e);
			return null;
		} 
	}
	
	@Transactional
	public void deleteBook(int id) throws Exception {
		Session session = null; 
		try{
			session = sessionFactory.getCurrentSession();
			bookDao.delete(session, bookDao.getById(session, new Integer(id)));
		} catch (HibernateException  e) {
			LOGGER.error(e);
		} 
	}
	
	
}
