package ui.src.com.senla.bookshop.facade.action.request;

import backend.src.com.senla.bookshop.storage.RequestStorage;
import backend.src.com.senla.bookshop.utils.csvworker.SaveObjectToCSV;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;
import ui.src.com.senla.bookshop.facade.utils.Scanners;

public class SaveRequestToCSV implements IAction{

	@Override
	public void execute() {
		Printers.show(RequestStorage.getInstance().getRequestsBooks());
		SaveObjectToCSV.requestWriteToCSV(Scanners.scannerForInteger());
	}
}
