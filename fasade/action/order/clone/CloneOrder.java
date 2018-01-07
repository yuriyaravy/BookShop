package by.home.book.fasade.action.order.clone;

import by.home.book.base.Order;
import by.home.book.fasade.IAction;
import by.home.book.instruments.Scanners;
import by.home.book.repository.BookManager;
import by.home.book.repository.OrderManager;

public class CloneOrder implements IAction{

	@Override
	public void execute() {
		OrderManager.showAllOrders();
		System.out.println("Select order by id: ");
		Order order = OrderManager.getOrderById(Scanners.scannerForInteger());
		OrderManager.cloneOrder(order);
	}
}
