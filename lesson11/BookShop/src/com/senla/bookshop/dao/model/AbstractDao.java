package com.senla.bookshop.dao.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.senla.bookshop.api.dao.IGenericDao;

public abstract class AbstractDao <T> implements IGenericDao<T>{
	
	private static final Logger logger = LogManager.getLogger(AbstractDao.class);
	
	protected abstract String getIdQuery();
	protected abstract String getInsertQuery();
	protected abstract String getDeleteQuery();
	protected abstract String getAllQuery();
	protected abstract String getUpdateQuery();
	
	protected abstract void prepareUpdateStatement(PreparedStatement statement, T object) throws SQLException;

	protected abstract void prepareInsertStatement(PreparedStatement statement, T object) throws SQLException;

	protected abstract T parseEntity(ResultSet resultSet);
	
	@Override
	public void create(Connection connection, T object) throws SQLException {
		PreparedStatement statement = null;
		try{
			statement = connection.prepareStatement(getInsertQuery());
			prepareInsertStatement(statement, object);
			statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}finally{
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
	public void delete(Connection connection, Integer id) throws SQLException {
		PreparedStatement statement = null;
		try{
			statement = connection.prepareStatement(getDeleteQuery());
			statement.setInt(1, id);
			if (statement.executeUpdate() == 0) {}
		} catch (SQLException e){
			logger.error(e);
		}finally{
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
	public T getById(Connection connection, Integer id) {
		PreparedStatement statement = null;
		try{
			statement = connection.prepareStatement(getIdQuery());
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				return parseEntity(rs);
			}
			return null;
			
		} catch (SQLException e){
			logger.error(e);
		}finally{
			try {
				if(statement != null){
					statement.close();
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}
		return null;
	}
	
	@Override
	public List<T> getAll(Connection connection, String... sortingColumn) {
		List<T> tempList = new ArrayList<>();
		Statement statement = null;
		try {
			statement = (Statement) connection.createStatement();
			String query = (sortingColumn.length == 1) ? getAllQuery() + " order by " + sortingColumn[0]
					: getAllQuery();
			System.out.println(query);
			ResultSet resultSet = statement.executeQuery(query);
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

	@Override
	public void update(Connection connection, T object) throws SQLException {
		PreparedStatement statement = null;
		try{
			statement = connection.prepareStatement(getUpdateQuery());
			prepareUpdateStatement(statement, object);
			statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}finally{
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
