package com.senla.bookshop.utils.comparators.order;

import java.util.Comparator;

import com.senla.bookshop.entities.Order;
import com.senla.bookshop.enums.OrderStatus;


public class ComparatorOrderBydateOfCompleate implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
			if(o1.getStatus() == OrderStatus.COMPLEATE && o2.getStatus() == OrderStatus.COMPLEATE){
				return o1.getDateOfDeliver().compareTo(o2.getDateOfDeliver());
		} else if (o1 != null && o2 == null) {
			return 1;
		} else {
			return -1;
		}		
	}
}
