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
import com.senla.bookshop.dao.api.IDataBaseDao;
import com.senla.bookshop.dao.connect.DataBaseConnect;

public abstract class ADataBaseDao <T> implements IDataBaseDao<T>{
	
	private static final Logger logger = LogManager.getLogger(ADataBaseDao.class);
	
	protected abstract String getIdQuery();
	protected abstract String getInsertQuery();
	protected abstract String getDeleteQuery();
	protected abstract String getAllQuery();
	protected abstract String getUpdateQuery();
	
	protected abstract void prepareUpdateStatement(PreparedStatement statement, T object) throws SQLException;

	protected abstract void prepareInsertStatement(PreparedStatement statement, T object) throws SQLException;

	protected abstract T parseEntity(ResultSet resultSet);
	
	
	@Override
	public void create(T object) throws SQLException {
		DataBaseConnect.getInstance().Connect();
		Connection dbConnect = (Connection) DataBaseConnect.getInstance().getMysqlConnect();
		
		PreparedStatement statement = null;
		try{
				statement = dbConnect.prepareStatement(getInsertQuery());
			prepareInsertStatement(statement, object);
			statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}finally{
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
		
	}

	@Override
	public void delete(Integer id) throws SQLException {
		DataBaseConnect.getInstance().Connect();
		Connection dbConnect = (Connection) DataBaseConnect.getInstance().getMysqlConnect();
		
		PreparedStatement statement = null;
		try{
			statement = dbConnect.prepareStatement(getDeleteQuery());
			statement.setInt(1, id);
			if (statement.executeUpdate() == 0) {}
		} catch (SQLException e){
			logger.error(e);
		}finally{
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}

	@Override
	public T getById(Integer id) {
		DataBaseConnect.getInstance().Connect();
		Connection dbConnect = (Connection) DataBaseConnect.getInstance().getMysqlConnect();
		PreparedStatement statement = null;
		try{
			statement = dbConnect.prepareStatement(getIdQuery());
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
				statement.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
		return null;
	}
	
	@Override
	public List<T> getAll(String... sortingColumn) {
		DataBaseConnect.getInstance().Connect();
		Connection dbConnect = (Connection) DataBaseConnect.getInstance().getMysqlConnect();
		
		List<T> tempList = new ArrayList<>();
		Statement statement = null;
		try {
			statement = (Statement) dbConnect.createStatement();
			String query = (sortingColumn.length == 1) ? getAllQuery() + " order by " + sortingColumn[0]
					: getAllQuery();
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
				statement.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}

	@Override
	public void update(T object) throws SQLException {
		DataBaseConnect.getInstance().Connect();
		Connection dbConnect = (Connection) DataBaseConnect.getInstance().getMysqlConnect();
		
		PreparedStatement statement = null;
		try{
			statement = dbConnect.prepareStatement(getUpdateQuery());
			prepareUpdateStatement(statement, object);
			statement.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
			logger.error(e);
		}finally{
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}

}
