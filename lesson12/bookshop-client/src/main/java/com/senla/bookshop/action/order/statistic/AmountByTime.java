package com.senla.bookshop.action.order.statistic;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;
import com.senla.bookshop.utils.Scanners;

public class AmountByTime implements IAction{

	@Override
	public void execute() {
		Printers.show("For how many days do you want to know your profit");
		try {
			Facade.getInstance().getProfitByPeriodOfTime(Scanners.scannerForInteger());
		} catch (Exception e) {
			Printers.show("Have problem with display profit by time");
		}
		
	}

}
