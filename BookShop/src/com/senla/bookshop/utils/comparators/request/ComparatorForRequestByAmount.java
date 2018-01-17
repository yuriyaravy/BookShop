package com.senla.bookshop.utils.comparators.request;

import java.util.Comparator;

import com.senla.bookshop.entities.Request;


public class ComparatorForRequestByAmount implements Comparator<Request>{
	
	@Override
	public int compare(Request o1, Request o2) {
			return o1.getBook().getCountOfRequest() - (o2.getBook().getCountOfRequest());
	}

}
