package backend.src.com.senla.bookshop.utils.comparators.book;

import java.util.Comparator;

import backend.src.com.senla.bookshop.entities.Book;


public class ComparatorBookByName implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		if(o1 != null && o2 != null) {
			return o1.getName().compareTo(o2.getName());
		} else if (o1 != null && o2 == null) {
			return 1;
		} else {
			return -1;
		}		
	}

}
