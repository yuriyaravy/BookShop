package com.senla.bookshop.dao.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
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
	
	private static final String UPDATE_BOOK = "update book set name=?, price=?, status=?, year_of_publication=?, date_of_add=now() where id_book=?"; 
	private static final String INSERT_INTO_BOOK = "insert into book(name, price, status, year_of_publication, date_of_add) value (?, ?, ?, ?, now());";
	private static final String SELECT_FROM_BOOK_BY_ID = "select * from book where id_book = ?";
	private static final String	DELETE_BOOK_BY_ID = "delete from book where id_book = ?";
	private static final String SELECT_ALL_FROM_BOOK = "select * from book";
	
	private static final String SELECT_OLD_BOOK = "select * from book where to_days(now()) - to_days(date_of_add) >= ;";

	@Override
	protected String getIdQuery() {
		return SELECT_FROM_BOOK_BY_ID;
	}
	@Override
	protected String getInsertQuery() {
		return INSERT_INTO_BOOK;
	}
	@Override
	protected String getDeleteQuery() {
		return DELETE_BOOK_BY_ID;
	}
	@Override
	protected String getAllQuery() {
		return SELECT_ALL_FROM_BOOK;
	}
	@Override
	protected String getUpdateQuery() {
		return UPDATE_BOOK;
	}
	@Override
	protected void prepareUpdateStatement(PreparedStatement statement, Book object) throws SQLException {
		prepareInsertStatement(statement , object);
		statement.setInt(5, object.getId());
	}
	@Override
	protected void prepareInsertStatement(PreparedStatement statement, Book object) throws SQLException {
		statement.setString(1, object.getName());
		statement.setDouble(2, object.getPrice());
		statement.setBoolean(3, object.isStatus());
		statement.setInt(4, object.getYearOfPublication());
	}
	@Override
	protected Book parseEntity(ResultSet resultSet) {
		try{
			Book tempBook = new Book();
			tempBook.setId(resultSet.getInt(ID_BOOK));
			tempBook.setName(resultSet.getString(NAME_BOOK));
			tempBook.setPrice(resultSet.getDouble(PRICE_BOOK));
			tempBook.setStatus(resultSet.getBoolean(STATUS_BOOK));
			tempBook.setYearOfPublication(resultSet.getInt(PUBLICATION_OF_BOOK));
			tempBook.setDate(resultSet.getDate(DATE_OF_ADD_BOOK));
			return tempBook;
		}catch (SQLException e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public List<Book> getBooks(Connection connection){
		return getAll(connection, ID_BOOK);
	}
	@Override
	public List<Book> getBookByName(Connection connection){
		return getAll(connection, NAME_BOOK);
	}
	@Override
	public List<Book> getBookByPrice(Connection connection){
		return getAll(connection, PRICE_BOOK);
	}
	@Override
	public List<Book> getBookByStatus(Connection connection){
		return getAll(connection, STATUS_BOOK);
	}
	@Override
	public List<Book> getBookByYearOfPublic(Connection connection){
		return getAll(connection, PUBLICATION_OF_BOOK);
	}
	@Override
	public List<Book> getBookByDate(Connection connection){
		return getAll(connection, DATE_OF_ADD_BOOK);
	}
	@Override
	public List<Book> getOldBook(Connection connection) throws Exception {
		List<Book> tempList = new ArrayList<>();
		int mounth = Setting.getMonth();
		Statement statement = null;
		try {
			statement = (Statement) connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_OLD_BOOK + mounth);
			while (resultSet.next()) {
				tempList.add(parseEntity(resultSet));
			}
			return tempList;
		} catch (SQLException e) {
			logger.error(e);
			return null;
		} finally {
			try {
				if(statement != null){
					statement.close();
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
}

	


