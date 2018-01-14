package com.senla.bookshop.action.order.work;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class CheckOrders implements IAction{

	@Override
	public void execute() {
		Printers.show(Facade.getInstance().getOrders());
		
	}

}
