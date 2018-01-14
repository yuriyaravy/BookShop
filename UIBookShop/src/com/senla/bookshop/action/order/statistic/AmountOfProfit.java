package com.senla.bookshop.action.order.statistic;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.controllers.OrderManager;
import com.senla.bookshop.facade.Facade;

public class AmountOfProfit implements IAction{

	@Override
	public void execute() {
		System.out.println("Our profit for all time : "+Facade.getInstance().getProfitForAllOrders()+"$");
		
	}

}
