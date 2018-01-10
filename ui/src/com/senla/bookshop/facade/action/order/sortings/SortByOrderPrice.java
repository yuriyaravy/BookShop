package ui.src.com.senla.bookshop.facade.action.order.sortings;

import java.util.Collections;

import backend.src.com.senla.bookshop.controllers.OrderManager;
import backend.src.com.senla.bookshop.storage.OrderStorage;
import backend.src.com.senla.bookshop.utils.comparators.order.ComparatorOrderByPrice;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;


public class SortByOrderPrice implements IAction{
	
	@Override
	public void execute() {
		Collections.sort(OrderStorage.getInstance().getOrdersBooks(), new ComparatorOrderByPrice());
		Printers.show(OrderStorage.getInstance().getOrdersBooks());
	}
}
