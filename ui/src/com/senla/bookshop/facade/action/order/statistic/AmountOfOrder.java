package ui.src.com.senla.bookshop.facade.action.order.statistic;

import backend.src.com.senla.bookshop.controllers.OrderManager;
import backend.src.com.senla.bookshop.facade.Facade;
import ui.src.com.senla.bookshop.facade.api.IAction;

public class AmountOfOrder implements IAction{

	@Override
	public void execute() {
		System.out.println("We have " + Facade.getInstance().getCountOfOrder() +" orders ");
		
	}

}
