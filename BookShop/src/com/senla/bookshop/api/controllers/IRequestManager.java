package com.senla.bookshop.api.controllers;

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

	void saveRequestToCSV(int id);

	public void serializationForRequest();

	void fillUpRequestStorage();
	

}
