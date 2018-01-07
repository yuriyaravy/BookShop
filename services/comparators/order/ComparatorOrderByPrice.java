package by.home.book.services.comparators.order;

import java.util.Comparator;

import by.home.book.base.Book;
import by.home.book.base.Order;
import by.home.book.repository.OrderManager;

public class ComparatorOrderByPrice implements Comparator<Order>{
	
	@Override
	public int compare(Order b1, Order b2) {
		return (int) (OrderManager.getProfitForOneOrder(b1) - OrderManager.getProfitForOneOrder(b2));
		
		
	}
}
