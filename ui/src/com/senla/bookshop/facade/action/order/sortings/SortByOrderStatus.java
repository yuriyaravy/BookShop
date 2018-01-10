package ui.src.com.senla.bookshop.facade.action.order.sortings;

import backend.src.com.senla.bookshop.facade.Facade;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;


public class SortByOrderStatus implements IAction{
	
	@Override
	public void execute() {
		Printers.show(Facade.getInstance().sortOrderByStatus());
	}

}
