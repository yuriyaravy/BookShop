package com.senla.bookshop.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.api.storages.IRequestStorage;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.utils.txtwork.TextDeserializ;

public class RequestStorage implements IRequestStorage{
	
	private List<Request> requestBooks = new ArrayList<>();
	
	private static RequestStorage requestStorage;
	
	private RequestStorage(){
	}
	
	public static  RequestStorage getInstance(){
		if(requestStorage == null){
			requestStorage = new RequestStorage();
		}
		return requestStorage;
	}

	@Override
	public void addRequestBooks(Request request) {
		request.setId(requestBooks.size());
		requestBooks.add(request);
	}

	@Override
	public List<Request> getRequestsBooks() {
		return requestBooks;
	}

	@Override
	public void setRequestsBooks(List<Request> requestBooks) {
		this.requestBooks = requestBooks;
	}
	
	@Override
	public List<Request> getRequests(Comparator<Request> comparator){
		if(comparator != null){
			Collections.sort(requestBooks, comparator);
		}
		return requestBooks;
	}
	@Override
	public Request getRequestById(int id){
		Request current  = null;
		for(Request temp : requestBooks) {
			if(temp.getId() == id){
				current = temp;
				break;
			}
		}
		return current;
	}
	@Override
	public void fillUpRequestStorage(String key){
		TextDeserializ textDeserializ = new TextDeserializ();
		List<Request> booksFromTxt = (List<Request>) textDeserializ.textDeserialez(key);
		setRequestsBooks(booksFromTxt);
	}

}
