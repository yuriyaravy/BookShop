package ui.src.com.senla.bookshop.facade.action.order.work;

import backend.src.com.senla.bookshop.controllers.OrderManager;
import backend.src.com.senla.bookshop.entities.Order;
import backend.src.com.senla.bookshop.storage.OrderStorage;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;

public class CheckOrders implements IAction{

	@Override
	public void execute() {
		Printers.show(OrderStorage.getInstance().getOrdersBooks());
		
	}

}
