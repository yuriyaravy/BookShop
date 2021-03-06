package com.senla.bookshop.utils.comparators.book;

import java.util.Comparator;

import com.senla.bookshop.entities.Book;


public class ComparatorBookByDate implements Comparator<Book>{
	
	
	@Override
	public int compare(Book o1, Book o2) {
			if (o1.getDate().before(o2.getDate())) {
	            return -1;
	        } else if (o1.getDate().after(o2.getDate())) {
	            return 1;
	        } else {
	            return 0;
	        }        
	}
}
