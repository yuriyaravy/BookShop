package backend.src.com.senla.bookshop.api.controllers;

import java.util.ArrayList;
import java.util.Comparator;

import backend.src.com.senla.bookshop.entities.Request;

public interface IRequestManager {
	
	public void addRequest(int id);
	
	public Request getRequestById(int id);

	public ArrayList<Request> getRequests(Comparator<Request> comparator);
	

}
