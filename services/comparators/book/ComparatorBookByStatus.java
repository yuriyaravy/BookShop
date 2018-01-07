package by.home.book.services.comparators.book;

import java.util.Comparator;

import by.home.book.base.Book;

public class ComparatorBookByStatus implements Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		return  Boolean.compare(b2.isStatus(),b1.isStatus());
	}
}


