package com.senla.bookshop.utils.comparators.book;

import java.util.Comparator;

import com.senla.bookshop.entities.Book;


public class ComparatorBookByPrice implements Comparator<Book>{
	
	@Override
	public int compare(Book b1, Book b2) {
			return (int) (((Book)b1).getPrice() - ((Book)b2).getPrice());
	}
}


