package backend.src.com.senla.bookshop.api.storages;

import java.util.ArrayList;

import backend.src.com.senla.bookshop.entities.Book;

public interface IBookStorage {
	
	public void addBook(Book book);
	
	public ArrayList<Book> getBooks();
	
	public void setBooks(ArrayList<Book> books);
	

}
