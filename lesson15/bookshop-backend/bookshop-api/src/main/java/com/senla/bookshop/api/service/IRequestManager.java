package com.senla.bookshop.api.service;

import java.util.List;

import com.senla.bookshop.entity.Request;

public interface IRequestManager {
	
	void getAnnotationRequest() throws Exception;

	List<Object[]> getAllBookRequestByName() throws Exception;

	Double getAllBookRequestByAmount() throws Exception;

	List<Request> getRequest() throws Exception;

	void saveAnnotationRequest() throws Exception;

	void addRequest(Request request) throws Exception;

	Request getRequestById(int id) throws Exception;

	void deleteRequest(int id) throws Exception;
	

}
