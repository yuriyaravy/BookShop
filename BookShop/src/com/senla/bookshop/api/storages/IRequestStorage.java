package com.senla.bookshop.api.storages;

import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.entities.Request;


public interface IRequestStorage {
	
	void addRequestBooks(Request request);
	
	List<Request> getRequestsBooks();
	
	void setRequestsBooks(List<Request> request);
	
	List<Request> getRequests(Comparator<Request> comparator);

	Request getRequestById(int id);

	void fillUpRequestStorage(String key);


}
