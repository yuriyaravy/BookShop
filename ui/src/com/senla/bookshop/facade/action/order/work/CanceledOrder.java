package ui.src.com.senla.bookshop.facade.action.order.work;

import backend.src.com.senla.bookshop.facade.Facade;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;
import ui.src.com.senla.bookshop.facade.utils.Scanners;

public class CanceledOrder implements IAction{

	@Override
	public void execute() {
		Printers.show(Facade.getInstance().getBooks());
		System.out.println();
		System.out.println("Write order id for canceled this order");
		Facade.getInstance().cancelOrder(Scanners.scannerForInteger());
	}
		
}


