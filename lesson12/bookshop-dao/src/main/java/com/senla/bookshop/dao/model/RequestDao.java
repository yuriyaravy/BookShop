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
import com.senla.bookshop.api.dao.IRequestDao;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entiti.Request;

public class RequestDao extends AbstractDao<Request> implements IRequestDao{
	
	private static final Logger logger = LogManager.getLogger(RequestDao.class);
	
	private static final String ID_REQUEST = "id_request";
	private static final String ID_BOOK = "id_book";
	
	private static final String NAME_BOOK = "name";
	private static final String PRICE_BOOK = "price";
	
	private static final String UPDATE_REQUEST = "update request set id_book=? where id_request=?"; 
	private static final String INSERT_INTO_REQUEST = "insert into request(id_book) value (?)";
	private static final String SELECT_FROM_REQUEST_BY_ID = "select * from request where id_request = ?";
	private static final String	DELETE_REQUEST_BY_ID = "delete from request where id_request = ?";
	private static final String SELECT_ALL_FROM_REQUEST = "select * from request";
	
	private static final String SELECT_BOOK_NAME_FROM_REQUEST = "select o.name from book as o, requests as p where o.id_book = p.id_book;";
	private static final String SELECT_REQUEST_BY_AMOUNT = "select o.price, o.name from book as o, requests as p where o.id_book = p.id_book order by o.price desc;";
	
	@Override
	public List<Double> getAllBookRequestByAmount(Connection connection) {
		List<Double> tempList = new ArrayList<>();
		Statement statement = null;
		try {
			statement = (Statement) connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_REQUEST_BY_AMOUNT);
			while (resultSet.next()) {
				tempList.add(resultSet.getDouble(PRICE_BOOK));
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
	@Override
	public List<String> getAllBookRequestByName(Connection connection) {
		List<String> tempList = new ArrayList<>();
		Statement statement = null;
		try {
			statement = (Statement) connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_BOOK_NAME_FROM_REQUEST);
			while (resultSet.next()) {
				tempList.add(resultSet.getString(NAME_BOOK));
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
	@Override
	protected String getIdQuery() {
		return SELECT_FROM_REQUEST_BY_ID;
	}

	@Override
	protected String getInsertQuery() {
		return INSERT_INTO_REQUEST;
	}

	@Override
	protected String getDeleteQuery() {
		return DELETE_REQUEST_BY_ID;
	}

	@Override
	protected String getAllQuery() {
		return SELECT_ALL_FROM_REQUEST;
	}

	@Override
	protected String getUpdateQuery() {
		return UPDATE_REQUEST;
	}

	@Override
	protected void prepareUpdateStatement(PreparedStatement statement, Request object) throws SQLException {
		statement.setInt(1, object.getId());
		statement.setInt(2, object.getBook().getId());
	}

	@Override
	protected void prepareInsertStatement(PreparedStatement statement, Request object) throws SQLException {
		statement.setInt(2, object.getBook().getId());
		
	}

	@Override
	protected Request parseEntity(ResultSet resultSet) {
		try{
			Request tempRequest = new Request();
			tempRequest.setId(resultSet.getInt(ID_REQUEST));
			if (resultSet.findColumn(ID_BOOK) > 0) {
				BookDao bookDao = (BookDao) DependencyIngection.getInctance().getClassInstance(BookDao.class);
				tempRequest.setBook(bookDao.parseEntity(resultSet));
			}
			return tempRequest;
		}catch (SQLException e) {
			logger.error(e);
			return null;
		}
	}
	
	@Override
	public List<Request> getRequest(Connection connection){
		return getAll(connection, ID_REQUEST);
	}

}
