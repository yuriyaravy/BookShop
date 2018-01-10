package backend.src.com.senla.bookshop.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	private void sortBooks(ArrayList<Book> books, Comparator<Book> comparator){
		if(comparator != null){
			Collections.sort(books, comparator);
		}
	}
	@Override
	public ArrayList<Book> getSortBook(Comparator<Book> comparator){
		sortBooks(books, comparator);
		return books;
	}

}
