package com.senla.bookshop.action.book;

import java.util.List;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.entiti.Book;
import com.senla.bookshop.server.Request;
import com.senla.bookshop.server.Response;
import com.senla.bookshop.server.ServerWorker;
import com.senla.bookshop.utils.Printers;

public class ShowAllBook implements IAction{
	
	private final static String GAB = "getAllBooks";

	@Override
	public void execute() {
		try {
			Request msg = new Request(GAB, null);
			Response resp =	(Response) ServerWorker.getInstance().sendRequest(msg);
			System.out.println(resp);
			List<Book> books = (List<Book>) resp.getObject();
			if(books == null || books.size() == 0){
				Printers.show("Its empty");
			}else {
				Printers.show(books);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Printers.show("Failed to display books ");
		}
		
	}

}
