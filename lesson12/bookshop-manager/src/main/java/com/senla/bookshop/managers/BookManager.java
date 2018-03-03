package com.senla.bookshop.managers;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.senla.bookshop.api.controllers.IBookManager;
import com.senla.bookshop.api.dao.IBookDao;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entiti.Book;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;
import com.senla.bookshop.utils.hibernate.HibernateUtil;

public class BookManager implements IBookManager{
	
	private static final Logger logger = LogManager.getLogger(BookManager.class);
	
	private final IBookDao bookDao = (IBookDao) DependencyIngection.getInctance().getClassInstance(IBookDao.class);
	private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	
	@Override
	public void getAnnotationBook() throws Exception{
		bookDao.create((Session) sessionFactory.openSession(), (Book) AnnotationCSVReader.readerFromCsv(Book.class));
	}
	
	@Override
	public void addBook(Book book) throws Exception{
		Session session = sessionFactory.openSession();
		try{
			session.beginTransaction();
			bookDao.create(session, book);
			session.getTransaction().commit();
		} catch (HibernateException  e) {
				session.getTransaction().rollback();
				logger.error(e);
		} finally {
				session.close();
		}
	}
	
	@Override
	public Book getBookById(int id) throws Exception{
		Session session = sessionFactory.openSession();
		Book book = null;
		try{
			session.beginTransaction();
			book = bookDao.getById(session, id);
			session.getTransaction().commit();
			return book;
		} catch (HibernateException  e) {
				session.getTransaction().rollback();
				logger.error(e);
				return null;
		} finally {
				session.close();
		}
	}
	
	@Override
	public List<Book> getBookByName() throws Exception{
		Session session = sessionFactory.openSession();
		List<Book> books = null;
		try{
			session.beginTransaction();
			books = bookDao.sortBookByName(session);
			session.getTransaction().commit();
			return books;
		} catch (HibernateException  e) {
			session.getTransaction().rollback();
			logger.error(e);
			return null;
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<Book> getBookByDate() throws Exception{
		Session session = sessionFactory.openSession();
		List<Book> books = null;
		try{
			session.beginTransaction();
			books = bookDao.sortBookByDate(session);
			session.getTransaction().commit();
			return books;
		} catch (HibernateException  e) {
			session.getTransaction().rollback();
			logger.error(e);
			return null;
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<Book> getBookByYearOfPublic() throws Exception{
		Session session = sessionFactory.openSession();
		List<Book> books = null;
		try{
			session.beginTransaction();
			books = bookDao.sortBookByYearOfPublic(session);
			session.getTransaction().commit();
			return books;
		} catch (HibernateException  e) {
			session.getTransaction().rollback();
			logger.error(e);
			return null;
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<Book> getBookByStatus() throws Exception{
		Session session = sessionFactory.openSession();
		List<Book> books = null;
		try{
			session.beginTransaction();
			books = bookDao.sortBookByStatus(session);
			session.getTransaction().commit();
			return books;
		} catch (HibernateException  e) {
			session.getTransaction().rollback();
			logger.error(e);
			return null;
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<Book> getBookByPrice() throws Exception{
		Session session = sessionFactory.openSession();
		List<Book> books = null;
		try{
			session.beginTransaction();
			books = bookDao.sortBookByPrice(session);
			session.getTransaction().commit();
			return books;
		} catch (HibernateException  e) {
			session.getTransaction().rollback();
			logger.error(e);
			return null;
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<Book> sortOldBooks() throws Exception {
		Session session = sessionFactory.openSession();
		List<Book> books = null;
		try{
			session.beginTransaction();
			books = bookDao.getOldBook(session); 
			session.getTransaction().commit();
			return books;
		} catch (HibernateException  e) {
			session.getTransaction().rollback();
			logger.error(e);
			return null;
		} finally {
			session.close();
		}
	}
	
	
}
