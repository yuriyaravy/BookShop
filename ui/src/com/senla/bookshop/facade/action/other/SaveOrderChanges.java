package ui.src.com.senla.bookshop.facade.action.other;

import backend.src.com.senla.bookshop.controllers.OrderManager;
import backend.src.com.senla.bookshop.storage.OrderStorage;
import backend.src.com.senla.bookshop.utils.txtworker.TextSerializ;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;

public class SaveOrderChanges implements IAction{

	@Override
	public void execute() {
		TextSerializ.getInstance().textOrderSerial(OrderStorage.getInstance().getOrdersBooks());
		
	}

}
