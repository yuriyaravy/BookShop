package com.senla.bookshop.action.order.sortings;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;


public class SortByOrderStatus implements IAction{
	
	@Override
	public void execute() {
		try {
			Printers.show(Facade.getInstance().sortOrderByStatus());
		} catch (Exception e) {
			Printers.show("Failed to display orders sorted by status");
		}
	}

}
