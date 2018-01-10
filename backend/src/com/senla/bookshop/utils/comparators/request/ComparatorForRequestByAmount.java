package backend.src.com.senla.bookshop.utils.comparators.request;

import java.util.Comparator;

import backend.src.com.senla.bookshop.entities.Request;


public class ComparatorForRequestByAmount implements Comparator<Request>{
	
	@Override
	public int compare(Request o1, Request o2) {
		if(o1 != null && o2 != null) {
			return o1.getBook().getCountOfRequest() - (o2.getBook().getCountOfRequest());
		} else if (o1 != null && o2 == null) {
			return 1;
		} else {
			return -1;
		}		
	}

}
