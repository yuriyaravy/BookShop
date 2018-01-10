package backend.src.com.senla.bookshop.controllers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.log4j.Logger;

import backend.src.com.senla.bookshop.api.controllers.IRequestManager;
import backend.src.com.senla.bookshop.entities.Book;
import backend.src.com.senla.bookshop.entities.Request;
import backend.src.com.senla.bookshop.storage.BookStorage;
import backend.src.com.senla.bookshop.storage.RequestStorage;
import backend.src.com.senla.bookshop.utils.csvworker.PathStorage;
import backend.src.com.senla.bookshop.utils.csvworker.ReadFromCSV;
import backend.src.com.senla.bookshop.utils.csvworker.SaveObjectToCSV;
import backend.src.com.senla.bookshop.utils.txtworker.TextSerializ;

public class RequestManager implements IRequestManager{
	
	private static final Logger logger = Logger.getLogger(RequestManager.class);
	
	@Override
	public void addRequest(int id){
		Book book = new BookManager().getBookById(id);
		RequestStorage.getInstance().addRequestBooks(new Request(book));
	}
	
	@Override
	public Request getRequestById(int id){
		Request current  = null;
		for(Request temp : RequestStorage.getInstance().getRequestsBooks()) {
			if(temp.getId() == id){
				current = temp;
				break;
			}
		}
		return current;
	}
	@Override
	public ArrayList<Request> getRequests(Comparator<Request> comparator){
		return RequestStorage.getInstance().getRequests(comparator);
	}
	@Override
	public void saveRequestToCSV(int id){
		SaveObjectToCSV.requestWriteToCSV(id);
	}
	@Override
	public ArrayList<String> readRequestFromCSV(){
		return ReadFromCSV.readCSV(new PathStorage().getCsvBookFile());
	}
	@Override
	public ArrayList<Request> getRequests(){
		return RequestStorage.getInstance().getRequestsBooks();
	}
	@Override
	public void serializationForRequest() {
		TextSerializ.getInstance().textReuqestSerial(RequestStorage.getInstance().getRequestsBooks());
	}


}