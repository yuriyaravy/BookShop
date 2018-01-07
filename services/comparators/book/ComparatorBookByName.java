package by.home.book.services.comparators.book;

import java.util.Comparator;

import by.home.book.base.Book;

public class ComparatorBookByName implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
