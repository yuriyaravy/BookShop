package com.senla.bookshop.api.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.entities.Request;

public interface IRequestManager {
	
	void addRequest(int id);
	
	Request getRequestById(int id);

	List<Request> getRequests(Comparator<Request> comparator);

	List<Request> getRequests();

	void readRequestFromCSV() throws ParseException;

	public void serializationForRequest();

	void fillUpRequestStorage();

	void saveRequestToCSV();

	void getAnnotationRequest() throws FileNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException, ParseException;
	

}
