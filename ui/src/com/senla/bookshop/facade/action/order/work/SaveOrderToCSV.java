package ui.src.com.senla.bookshop.facade.action.order.work;

import backend.src.com.senla.bookshop.storage.OrderStorage;
import backend.src.com.senla.bookshop.utils.csvworker.SaveObjectToCSV;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;
import ui.src.com.senla.bookshop.facade.utils.Scanners;

public class SaveOrderToCSV implements IAction{

	@Override
	public void execute() {
		Printers.show(OrderStorage.getInstance().getOrdersBooks());
		SaveObjectToCSV.orderWriteToCSV(Scanners.scannerForInteger());
	}

}
