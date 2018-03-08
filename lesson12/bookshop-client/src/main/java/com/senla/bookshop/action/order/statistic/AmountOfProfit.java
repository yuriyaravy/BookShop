package com.senla.bookshop.action.order.statistic;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class AmountOfProfit implements IAction{

	@Override
	public void execute() {
		try {
			Printers.show("Our profit for all time : "+Facade.getInstance().getProfitForAllOrders()+"$");
		} catch (Exception e) {
			Printers.show("get errore with profit");
		}
		
	}

}
