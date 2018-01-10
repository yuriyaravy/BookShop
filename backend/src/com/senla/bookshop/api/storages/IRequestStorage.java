package backend.src.com.senla.bookshop.api.storages;

import java.util.ArrayList;

import backend.src.com.senla.bookshop.entities.Request;


public interface IRequestStorage {
	
	public void addRequestBooks(Request request);
	
	public ArrayList<Request> getRequestsBooks();
	
	public void setRequestsBooks(ArrayList<Request> request);

}
