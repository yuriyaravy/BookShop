package ui.src.com.senla.bookshop.facade.action.order.sortings;

import java.util.Collections;

import backend.src.com.senla.bookshop.facade.Facade;
import backend.src.com.senla.bookshop.storage.OrderStorage;
import backend.src.com.senla.bookshop.utils.comparators.order.ComparatorOrderBydateOfCompleate;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;


public class SortByPriceOfExecutOrders implements IAction{
	
	@Override
	public void execute() {
		Printers.show(Facade.getInstance().sortOrderByCompleate());
	}

}
