package com.senla.bookshop.utils.comparators.order;

import java.util.Comparator;

import com.senla.bookshop.entities.Order;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.managers.OrderManager;



public class ComparatorOrderByPrice implements Comparator<Order>{
	@Override
	public int compare(Order b1, Order b2) {
			return (int) (Facade.getInstance().getProfitForOneOrder(b1) - Facade.getInstance().getProfitForOneOrder(b2));
	}
}
