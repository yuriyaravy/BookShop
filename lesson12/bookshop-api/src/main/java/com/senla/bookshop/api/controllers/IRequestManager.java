package com.senla.bookshop.api.controllers;

import java.util.List;

import com.senla.bookshop.entiti.Request;

public interface IRequestManager {
	
	void getAnnotationRequest() throws Exception;

	List<Object[]> getAllBookRequestByName() throws Exception;

	Double getAllBookRequestByAmount() throws Exception;

	List<Request> getRequest() throws Exception;

	void saveAnnotationRequest() throws Exception;

	void addRequest(Request request) throws Exception;
	

}
