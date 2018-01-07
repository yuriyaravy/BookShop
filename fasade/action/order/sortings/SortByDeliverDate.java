package by.home.book.fasade.action.order.sortings;

import java.util.Collections;

import by.home.book.base.Order;
import by.home.book.fasade.IAction;
import by.home.book.repository.OrderManager;
import by.home.book.services.comparators.order.ComparatorDateOfDeliver;

public class SortByDeliverDate implements IAction{

	@Override
	public void execute() {
		Collections.sort(OrderManager.orderBooks, new ComparatorDateOfDeliver());
		OrderManager.showAllOrders();
	}

}
