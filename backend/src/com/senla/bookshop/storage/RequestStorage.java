package backend.src.com.senla.bookshop.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import backend.src.com.senla.bookshop.api.storages.IRequestStorage;
import backend.src.com.senla.bookshop.entities.Request;

public class RequestStorage implements IRequestStorage{
	
	private ArrayList<Request> requestBooks = new ArrayList<>();
	
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
		request.setId(requestBooks.size()-1);
		requestBooks.add(request);
	}

	@Override
	public ArrayList<Request> getRequestsBooks() {
		return requestBooks;
	}

	@Override
	public void setRequestsBooks(ArrayList<Request> requestBooks) {
		this.requestBooks = requestBooks;
	}
	
	private void sortReuqest(ArrayList<Request> requstBook, Comparator<Request> comparator){
		if(comparator != null){
			Collections.sort(requstBook, comparator);
		}
	}
	@Override
	public ArrayList<Request> getRequests(Comparator<Request> comparator){
		sortReuqest(requestBooks, comparator);
		return requestBooks;
	}

}
