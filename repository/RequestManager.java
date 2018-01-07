package by.home.book.repository;

import java.util.ArrayList;

import by.home.book.DAO.TextDeserializ;
import by.home.book.base.Book;
import by.home.book.base.Order;
import by.home.book.base.Request;
import by.home.book.instruments.Id;

public class RequestManager {
	
	public static ArrayList<Request> requestBooks = new ArrayList<>();
	
	public static void showAllRequests(){
		for(Request temp : requestBooks){
			System.out.println(temp);
		}
	}
	
	public static void addRequest(int id){
		Book book = BookManager.getBookById(id);
		requestBooks.add(new Request(Id.creationId() , book));
	}
	
	public static Request getRequestById(int id){
		Request current  = null;
		for(Request temp : requestBooks) {
			if(temp.getId() == id){
				current = temp;
				break;
			}
		}
		return current;
	}

}
