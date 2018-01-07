package by.home.book.fasade.action.order.work;

import by.home.book.fasade.IAction;
import by.home.book.instruments.Scanners;
import by.home.book.repository.OrderManager;

public class AddOrder implements IAction{

	@Override
	public void execute() {
		System.out.println("write books id which you want to add to order");
		OrderManager.addBookToOrder(Scanners.scannerForInteger());
	}

}
