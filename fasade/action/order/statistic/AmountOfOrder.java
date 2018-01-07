package by.home.book.fasade.action.order.statistic;

import by.home.book.fasade.IAction;
import by.home.book.repository.OrderManager;

public class AmountOfOrder implements IAction{

	@Override
	public void execute() {
		System.out.println("We have " + OrderManager.getCountOfOrder() +" orders ");
		
	}

}
