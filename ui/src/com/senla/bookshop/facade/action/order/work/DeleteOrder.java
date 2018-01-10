package ui.src.com.senla.bookshop.facade.action.order.work;

import backend.src.com.senla.bookshop.controllers.OrderManager;
import backend.src.com.senla.bookshop.entities.Order;
import backend.src.com.senla.bookshop.facade.Facade;
import backend.src.com.senla.bookshop.storage.OrderStorage;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;
import ui.src.com.senla.bookshop.facade.utils.Scanners;

public class DeleteOrder implements IAction{

	@Override
	public void execute() {
		Printers.show(OrderStorage.getInstance().getOrdersBooks());
		System.out.println();
		System.out.println("Write order id for delete this order");
		Facade.getInstance().deleteBookToOrder(Scanners.scannerForInteger());
	}

}
