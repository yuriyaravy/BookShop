package ui.src.com.senla.bookshop.facade.action.order.statistic;

import backend.src.com.senla.bookshop.controllers.OrderManager;
import backend.src.com.senla.bookshop.facade.Facade;
import ui.src.com.senla.bookshop.facade.api.IAction;

public class AmountOfProfit implements IAction{

	@Override
	public void execute() {
		System.out.println("Our profit for all time : "+Facade.getInstance().getProfitForAllOrders()+"$");
		
	}

}
