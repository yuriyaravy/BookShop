package by.home.book.repository;

import java.util.ArrayList;

import by.home.book.DAO.TextDeserializ;
import by.home.book.base.Book;

public class BookManager {
	
	public static ArrayList<Book> books = new ArrayList<>();
	
	public static ArrayList<Book> booksTest = new ArrayList<Book>();
	
	public static void showAllBooks(){
		for(Book temp : books){
			System.out.println(temp);
		}
	}
	
	public static Book getBookById(int id){
		Book current  = null;
		
		for(Book temp : books) {
			if(temp.getId() == id){
				current = temp;
				break;
			}
		}
		return current;
	}
	
	
}
