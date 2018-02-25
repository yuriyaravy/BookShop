package com.senla.bookshop.api.dao;

import java.util.List;

import com.mysql.jdbc.Connection;
import com.senla.bookshop.entiti.Request;

public interface IRequestDao extends IGenericDao<Request>{

	List<String> getAllBookRequestByName(Connection connection);

	List<Double> getAllBookRequestByAmount(Connection connection);

	List<Request> getRequest(Connection connection);

}
