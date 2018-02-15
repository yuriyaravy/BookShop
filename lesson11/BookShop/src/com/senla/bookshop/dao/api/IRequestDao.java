package com.senla.bookshop.dao.api;

import java.util.List;

import com.mysql.jdbc.Connection;
import com.senla.bookshop.entities.Request;

public interface IRequestDao extends IDataBaseDao<Request>{

	List<String> getAllBookRequestByName(Connection connection);

	List<Double> getAllBookRequestByAmount(Connection connection);

	List<Request> getRequest(Connection connection);

}
