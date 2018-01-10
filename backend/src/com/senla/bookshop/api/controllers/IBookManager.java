package backend.src.com.senla.bookshop.api.controllers;

import backend.src.com.senla.bookshop.entities.Book;

public interface IBookManager {
	
	public Book getBookById(int id);

}
