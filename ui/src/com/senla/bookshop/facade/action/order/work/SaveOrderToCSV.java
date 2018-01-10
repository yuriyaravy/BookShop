package ui.src.com.senla.bookshop.facade.action.order.work;

import backend.src.com.senla.bookshop.facade.Facade;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;
import ui.src.com.senla.bookshop.facade.utils.Scanners;

public class SaveOrderToCSV implements IAction{

	@Override
	public void execute() {
		Printers.show(Facade.getInstance().getOrders());
		Facade.getInstance().saveOrderToCSV(Scanners.scannerForInteger());
	}

}
