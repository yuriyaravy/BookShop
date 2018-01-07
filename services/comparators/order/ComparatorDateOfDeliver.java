package by.home.book.services.comparators.order;

import java.util.Comparator;

import by.home.book.base.Order;

public class ComparatorDateOfDeliver implements Comparator<Order>{
	
	@Override
	public int compare(Order o1, Order o2) {
		return o1.getDateOfDeliver().compareTo(o2.getDateOfDeliver());
	}

}
