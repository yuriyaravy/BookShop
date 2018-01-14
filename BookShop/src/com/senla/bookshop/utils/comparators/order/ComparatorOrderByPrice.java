package com.senla.bookshop.utils.comparators.order;

import java.util.Comparator;

import com.senla.bookshop.controllers.OrderManager;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.facade.Facade;



public class ComparatorOrderByPrice implements Comparator<Order>{
	@Override
	public int compare(Order b1, Order b2) {
		if(b1 != null && b2 != null) {
			return (int) (Facade.getInstance().getProfitForOneOrder(b1) - Facade.getInstance().getProfitForOneOrder(b2));
		} else if (b1 != null && b2 == null) {
			return 1;
		} else {
			return -1;
		}	
		
	}
}
