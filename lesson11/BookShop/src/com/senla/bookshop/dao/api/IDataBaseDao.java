package com.senla.bookshop.dao.api;

import java.sql.SQLException;
import java.util.List;


public interface IDataBaseDao<T> {
	
	void create(T t) throws SQLException;
	
	void delete(Integer id) throws SQLException;
	
	T getById(Integer id);
	
	void update(T object) throws SQLException;

	List<T> getAll(String[] sortingColumn);

}
