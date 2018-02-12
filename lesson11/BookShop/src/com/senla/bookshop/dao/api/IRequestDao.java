package com.senla.bookshop.dao.api;

import java.util.List;

import com.senla.bookshop.entities.Request;

public interface IRequestDao extends IDataBaseDao<Request>{

	List<String> getAllBookRequestByName();

	List<Double> getAllBookRequestByAmount();

	List<Request> getRequest();

}
