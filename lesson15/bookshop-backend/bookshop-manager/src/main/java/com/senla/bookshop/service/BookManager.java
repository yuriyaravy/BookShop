package com.senla.bookshop.service;

import java.util.List;

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
public class BookManager implements IBookManager {

	@Autowired
	private IBookDao bookDao;

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void getAnnotationBook() throws Exception {
		bookDao.create((Session) sessionFactory.openSession(), (Book) AnnotationCSVReader.readerFromCsv(Book.class));
	}

	@Transactional
	public void addBook(Book book) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		bookDao.create(session, book);
	}

	@Transactional
	public Book getBookById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Book book = null;
		book = bookDao.getById(session, id);
		return book;
	}

	@Transactional
	public List<Book> getBookByName() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = null;
		books = bookDao.sortBookByName(session);
		return books;
	}

	@Transactional
	public List<Book> getBookByDate() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = null;
		books = bookDao.sortBookByDate(session);
		return books;
	}

	@Transactional
	public List<Book> getBookByYearOfPublic() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = null;
		books = bookDao.sortBookByYearOfPublic(session);
		return books;
	}

	@Transactional
	public List<Book> getBookByStatus() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = bookDao.sortBookByStatus(session);
		return books;
	}

	@Transactional
	public List<Book> getBookByPrice() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = bookDao.sortBookByPrice(session);
		return books;
	}

	@Transactional
	public List<Book> sortOldBooks() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = bookDao.getOldBook(session);
		return books;
	}

	@Transactional
	public void deleteBook(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		bookDao.delete(session, bookDao.getById(session, new Integer(id)));
	}

}
