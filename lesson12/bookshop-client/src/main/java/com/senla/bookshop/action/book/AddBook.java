package com.senla.bookshop.action.book;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.entity.Book;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.server.Request;
import com.senla.bookshop.server.Response;
import com.senla.bookshop.server.ServerWorker;
import com.senla.bookshop.utils.Printers;

public class AddBook implements IAction{
	
	final static Logger logger = Logger.getLogger(AddBook.class);
	
	private final static String AB = "addBook";
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		Integer publication = null;
		Double price = null;
		try{
			Printers.show("Name of the book:");
			String name = sc.nextLine();
			Printers.show("Price of the book:");
			if(sc.hasNextInt()){
				price = (double) sc.nextInt();
			}
			Printers.show("Year of publication:");
			if(sc.hasNextInt()){
				publication = sc.nextInt();
			}
			boolean status = true;
			Book book = new Book(null, name, price, status, publication);
			
			Request reqestServer = new Request(AB, new Object[] {book});
			Response resp = ServerWorker.getInstance().sendRequest(reqestServer);
			if(resp.isOk()){
				Printers.show("Book was added");
			}else{
				Printers.show("Book was not added");
			}
		}catch (Exception e){
			logger.error(e);
			Printers.show("We have problem with adding a new book");
		}
		
	}

}
