package com.senla.bookshop.dao.api;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;


public interface IDataBaseDao<T> {
	
	void create(Connection connection, T object) throws SQLException;
	
	void delete(Connection connection, Integer id) throws SQLException;
	
	void update(Connection connection,T object) throws SQLException;

	List<T> getAll(Connection connection, String[] sortingColumn);

	T getById(Connection connection, Integer id);

}
