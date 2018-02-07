package com.senla.bookshop.utils.comparators.book;

import java.util.Comparator;

import com.senla.bookshop.entities.Book;


public class ComparatorBookByYearOfPublic implements Comparator<Book>{
	
	@Override
	public int compare(Book o1, Book o2) {
			return ((Book)o1).getYearOfPublication() - ((Book)o2).getYearOfPublication();
	}
	
}
