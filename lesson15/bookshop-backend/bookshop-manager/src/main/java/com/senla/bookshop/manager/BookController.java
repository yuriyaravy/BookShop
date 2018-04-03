package com.senla.bookshop.manager;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.bookshop.api.controller.IBookManager;
import com.senla.bookshop.api.dao.IBookDao;
import com.senla.bookshop.entity.Book;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;
import com.senla.bookshop.utils.hibernate.HibernateUtil;

@RestController
@Transactional(rollbackFor = {Exception.class})
public class BookController implements IBookManager{
	
	private static final Logger LOGGER = LogManager.getLogger(BookController.class);
	
	@Autowired
	private IBookDao bookDao;
	private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	
	@Override
	public void getAnnotationBook() throws Exception{
		bookDao.create((Session) sessionFactory.openSession(), (Book) AnnotationCSVReader.readerFromCsv(Book.class));
	}
	
	@Override
	@RequestMapping(value = "/create-book", method = RequestMethod.POST)
	public void addBook(Book book) throws Exception{
		try{
		Session session = sessionFactory.getCurrentSession();
		bookDao.create(session, book);
		} catch (HibernateException  e) {
			LOGGER.error(e);
		}
	}
	
	@Override
	@RequestMapping(value = "/get-book-by-id", method = RequestMethod.GET)
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
	
	@Override
	@RequestMapping(value = "/sort-book-by-name", method = RequestMethod.GET)
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
	
	@Override
	@RequestMapping(value = "/sort-book-by-name", method = RequestMethod.GET)
	public List<Book> getBookByDate() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = null;
		try{
			session.beginTransaction();
			books = bookDao.sortBookByDate(session);
			session.getTransaction().commit();
			return books;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		} 
	}
	
	@Override
	public List<Book> getBookByYearOfPublic() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = null;
		try{
			session.beginTransaction();
			books = bookDao.sortBookByYearOfPublic(session);
			session.getTransaction().commit();
			return books;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		} 
	}
	
	@Override
	public List<Book> getBookByStatus() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = null;
		try{
			session.beginTransaction();
			books = bookDao.sortBookByStatus(session);
			session.getTransaction().commit();
			return books;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		} 
	}
	
	@Override
	public List<Book> getBookByPrice() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = null;
		try{
			session.beginTransaction();
			books = bookDao.sortBookByPrice(session);
			session.getTransaction().commit();
			return books;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
				LOGGER.error(e);
			return null;
		} 
	}
	
	@Override
	public List<Book> sortOldBooks() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = null;
		try{
			session.beginTransaction();
			books = bookDao.getOldBook(session); 
			session.getTransaction().commit();
			return books;
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
			return null;
		} 
	}
	
	@Override
	public void deleteBook(int id) throws Exception {
		Session session = null; 
		try{
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			bookDao.delete(session, bookDao.getById(session, new Integer(id)));
			session.getTransaction().commit();
		} catch (HibernateException  e) {
			if(session.getTransaction()!= null){
				session.getTransaction().rollback();
			}
			LOGGER.error(e);
		} 
	}
	
	
}
