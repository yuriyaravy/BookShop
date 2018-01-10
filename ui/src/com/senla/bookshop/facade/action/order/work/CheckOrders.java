package ui.src.com.senla.bookshop.facade.action.order.work;

import backend.src.com.senla.bookshop.facade.Facade;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;

public class CheckOrders implements IAction{

	@Override
	public void execute() {
		Printers.show(Facade.getInstance().getOrders());
		
	}

}