package backend.src.com.senla.bookshop.api.controllers;

import java.util.ArrayList;
import java.util.Comparator;

import backend.src.com.senla.bookshop.entities.Book;

public interface IBookManager {
	
	public Book getBookById(int id);

	ArrayList<Book> getBook(Comparator<Book> comparator);

	void saveBookToCSV(int id);

	ArrayList<Book> getBooks();

	ArrayList<String> readBookFromCSV();

	void serializationForBooks();

}
