package by.home.book.services.comparators.book;

import java.util.Comparator;

import by.home.book.base.Book;

public class ComparatorBookByYearOfPublic implements Comparator<Book>{
	
	@Override
	public int compare(Book o1, Book o2) {
		return ((Book)o1).getYearOfPublication() - ((Book)o2).getYearOfPublication();
	}
	
}
