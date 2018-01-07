package by.home.book.fasade.action.order.work;

import by.home.book.fasade.IAction;
import by.home.book.repository.OrderManager;

public class AddBookToStorage implements IAction{

	@Override
	public void execute() {
		OrderManager.allOrderCompleate();
	}

}
