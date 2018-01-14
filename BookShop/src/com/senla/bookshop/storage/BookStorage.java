package com.senla.bookshop.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.api.storages.IBookStorage;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.utils.txtwork.TextDeserializ;

public class BookStorage implements IBookStorage{
	
	private List<Book> books = new ArrayList<>();
	
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
		books.add(book);
	}
	
	@Override
	public List<Book> getBooks() {
		return books;
	}
	
	@Override
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@Override
	public List<Book> getSortBook(Comparator<Book> comparator){
		if(comparator != null){
			Collections.sort(books, comparator);
		}
		return books;
	}
	@Override
	public Book getBookById(int id){
		Book current  = null;
		for(Book temp : books) {
			if(temp.getId() == id){
				current = temp;
				break;
			}
		}
		return current;
	}
	@Override
	public void fillUpBookStorage(String key){
		TextDeserializ textDeserializ = new TextDeserializ();
		List<Book> booksFromTxt = (List<Book>) textDeserializ.textDeserialez(key);
		setBooks(booksFromTxt);
	}

}
