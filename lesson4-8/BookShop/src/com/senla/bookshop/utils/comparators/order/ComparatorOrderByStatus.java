package com.senla.bookshop.utils.comparators.order;

import java.util.Comparator;

import com.senla.bookshop.entities.Order;


public class ComparatorOrderByStatus implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
			return o1.getStatus().compareTo(o2.getStatus());
	}

}
