package com.senla.bookshop.dao.model;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.senla.bookshop.api.dao.IBookDao;
import com.senla.bookshop.entiti.Book;
import com.senla.bookshop.utils.setting.Setting;

public class BookDao extends AbstractDao<Book> implements IBookDao{
	
	private static final Logger logger = LogManager.getLogger(BookDao.class);
	
	private static final String ID_BOOK = "id_book";
	private static final String NAME_BOOK = "name";
	private static final String PRICE_BOOK = "price";
	private static final String STATUS_BOOK = "status";
	private static final String PUBLICATION_OF_BOOK = "year_of_publication";
	private static final String DATE_OF_ADD_BOOK = "date_of_add";
	
	@Override
	public List<Book> getBook(Session session){
		return getAll(session);
	}
	@Override
	public List<Book> sortBookByName(Session session){
		return getAll(session, NAME_BOOK);
	}
	@Override
	public List<Book> sortBookByPrice(Session session){
		return getAll(session, PRICE_BOOK);
	}
	@Override
	public List<Book> sortBookByStatus(Session session){
		return getAll(session, STATUS_BOOK);
	}
	@Override
	public List<Book> sortBookByYearOfPublic(Session session){
		return getAll(session, PUBLICATION_OF_BOOK);
	}
	@Override
	public List<Book> sortBookByDate(Session session){
		return getAll(session, DATE_OF_ADD_BOOK);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getOldBook(Session session) {
		List<Book> books = null;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, - Setting.getMonth());
		Criteria criteria = session.createCriteria(Book.class);
		criteria.add(Restrictions.ge("date", calendar.getTime()));
		books = criteria.list();
		return books;
	}
	@Override
	public List<Book> getAll(Session session, Class<Book> type) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

	


