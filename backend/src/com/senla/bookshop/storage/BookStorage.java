package backend.src.com.senla.bookshop.storage;

import java.util.ArrayList;

import backend.src.com.senla.bookshop.api.storages.IBookStorage;
import backend.src.com.senla.bookshop.entities.Book;

public class BookStorage implements IBookStorage{
	
	private ArrayList<Book> books = new ArrayList<>();
	
	private static BookStorage bookStorage;
	
	private BookStorage(){
	}
	
	public static BookStorage getInstance(){
		if(bookStorage == null){
			bookStorage = new BookStorage();
		}
		return bookStorage;
	}
	
	@Override
	public void addBook(Book book) {
		book.setId(books.size()-1);
		books.add(book);
	}
	
	@Override
	public ArrayList<Book> getBooks() {
		return books;
	}
	
	@Override
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}


}
