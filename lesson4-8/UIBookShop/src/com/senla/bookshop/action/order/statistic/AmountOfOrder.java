package com.senla.bookshop.action.order.statistic;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.managers.OrderManager;
import com.senla.bookshop.utils.Printers;

public class AmountOfOrder implements IAction{

	@Override
	public void execute() {
		Printers.show("We have " + Facade.getInstance().getCountOfOrder() +" orders ");
		
	}

}
