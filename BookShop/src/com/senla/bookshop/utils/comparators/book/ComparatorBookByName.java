package com.senla.bookshop.utils.comparators.book;

import java.util.Comparator;

import com.senla.bookshop.entities.Book;


public class ComparatorBookByName implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
			return o1.getName().compareTo(o2.getName());
	}

}
