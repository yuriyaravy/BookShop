package com.senla.bookshop.api.controllers;

import java.sql.SQLException;
import java.util.List;

import com.senla.bookshop.entiti.Request;

public interface IRequestManager {
	
	void getAnnotationRequest() throws Exception;

	List<String> getAllBookRequestByName() throws Exception;

	void addRequest(Object t) throws SQLException, Exception;

	List<Double> getAllBookRequestByAmount() throws Exception;

	List<Request> getRequest() throws Exception;

	void saveAnnotationRequest() throws Exception;
	

}
