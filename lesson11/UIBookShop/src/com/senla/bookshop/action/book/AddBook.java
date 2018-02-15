package com.senla.bookshop.action.book;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class AddBook implements IAction{
	
	final static Logger logger = Logger.getLogger(AddBook.class);

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
		Facade.getInstance().addBook(book); 
		}catch (Exception e){
			logger.error(e);
			Printers.show("We have problem with adding a new book");
		}
		
	}

}
