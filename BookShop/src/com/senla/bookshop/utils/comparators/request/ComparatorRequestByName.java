package com.senla.bookshop.utils.comparators.request;

import java.util.Comparator;

import com.senla.bookshop.entities.Request;


public class ComparatorRequestByName implements Comparator<Request>{

	@Override
	public int compare(Request o1, Request o2) {
		if(o1 != null && o2 != null) {
			return o1.getBook().getName().compareTo(o2.getBook().getName());
		} else if (o1 != null && o2 == null) {
			return 1;
		} else {
			return -1;
		}		
	}

}
