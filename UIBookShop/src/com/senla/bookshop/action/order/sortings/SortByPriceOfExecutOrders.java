package com.senla.bookshop.action.order.sortings;

import java.util.Collections;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.storage.OrderStorage;
import com.senla.bookshop.utils.Printers;
import com.senla.bookshop.utils.comparators.order.ComparatorOrderBydateOfCompleate;


public class SortByPriceOfExecutOrders implements IAction{
	
	@Override
	public void execute() {
		Printers.show(Facade.getInstance().sortOrderByCompleate());
	}

}
