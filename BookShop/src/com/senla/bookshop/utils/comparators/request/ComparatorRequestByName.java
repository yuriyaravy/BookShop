package com.senla.bookshop.utils.comparators.request;

import java.util.Comparator;

import com.senla.bookshop.entities.Request;


public class ComparatorRequestByName implements Comparator<Request>{

	@Override
	public int compare(Request o1, Request o2) {
			return o1.getBook().getName().compareTo(o2.getBook().getName());
	}

}
