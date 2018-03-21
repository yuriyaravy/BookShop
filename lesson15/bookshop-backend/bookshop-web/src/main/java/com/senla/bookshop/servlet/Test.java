package com.senla.bookshop.servlet;

import java.util.List;

import com.google.gson.Gson;
import com.senla.bookshop.entity.Book;
import com.senla.bookshop.facade.Facade;

public class Test {

	public static void main(String[] args) {
		
		try {
			List<Book> books = Facade.getInstance().getBooks();
			Book book = Facade.getInstance().getBookById(1);
			System.out.println(book);
			System.out.println(books);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
