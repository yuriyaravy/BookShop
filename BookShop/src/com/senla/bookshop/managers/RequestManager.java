package com.senla.bookshop.managers;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.bookshop.api.controllers.IRequestManager;
import com.senla.bookshop.api.storages.IRequestStorage;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.storage.BookStorage;
import com.senla.bookshop.storage.OrderStorage;
import com.senla.bookshop.storage.RequestStorage;
import com.senla.bookshop.utils.csvwork.ParseToObject;
import com.senla.bookshop.utils.csvwork.ReadFromCSV;
import com.senla.bookshop.utils.csvwork.SaveObjectToCSV;
import com.senla.bookshop.utils.setting.Setting;
import com.senla.bookshop.utils.txtwork.TextSerializ;

public class RequestManager implements IRequestManager{
	
	private final IRequestStorage requestStorage = RequestStorage.getInstance();
	
	private static final Logger logger = Logger.getLogger(RequestManager.class);
	
	private final String PROPARTY_KEY = "requestPath";
	
	private final String PROPARTY_KEY_CSV = "requestPathCSV";
	
	@Override
	public void addRequest(int id){
		Book book = new BookManager().getBookById(id);
		requestStorage.addRequestBooks(new Request(book));
	}
	
	@Override
	public Request getRequestById(int id){
		return requestStorage.getRequestById(id);
	}
	@Override
	public List<Request> getRequests(Comparator<Request> comparator){
		return requestStorage.getRequests(comparator);
	}
	@Override
	public void saveRequestToCSV(){
		SaveObjectToCSV.requestWriteToCSV();
	}
	@Override
	public void readRequestFromCSV() throws ParseException{
		List<Request> csvRequest = ParseToObject.stringToRequest(ReadFromCSV.readCSV(PROPARTY_KEY_CSV));
		Request newRequest = null;
		for(Request tempCSV : csvRequest){
			for(int i = 0; i < requestStorage.getRequestsBooks().size(); i++){
				if(tempCSV.getId() != requestStorage.getRequestsBooks().get(i).getId()){
					newRequest = tempCSV;
				}
			}
			requestStorage.addRequestBooks(newRequest);
		}
	}
	@Override
	public List<Request> getRequests(){
		return requestStorage.getRequestsBooks();
	}
	@Override
	public void serializationForRequest() {
		TextSerializ.textSerialize(RequestStorage.getInstance().getRequestsBooks(), PROPARTY_KEY);
	}
	@Override
	public void fillUpRequestStorage(){
		requestStorage.fillUpRequestStorage(PROPARTY_KEY);
	}


}
