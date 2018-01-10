package backend.src.com.senla.bookshop.utils.comparators.book;

import java.util.Comparator;

import backend.src.com.senla.bookshop.entities.Book;


public class ComparatorBookByDate implements Comparator<Book>{
	
	
	@Override
	public int compare(Book o1, Book o2) {
		if(o1 != null && o2 != null) {	
			if (o1.getDate().before(o2.getDate())) {
	            return -1;
	        } else if (o1.getDate().after(o2.getDate())) {
	            return 1;
	        } else {
	            return 0;
	        }        
		} else if (o1 != null && o2 == null) {
			return 1;
		} else {
			return -1;
		}		
	}
}
