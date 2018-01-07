package by.home.book.fasade.action.order.statistic;

import by.home.book.fasade.IAction;
import by.home.book.repository.OrderManager;

public class AmountOfProfit implements IAction{

	@Override
	public void execute() {
		System.out.println("Our profit for all time : "+OrderManager.getProfitForAllOrders()+"$");
		
	}

}
