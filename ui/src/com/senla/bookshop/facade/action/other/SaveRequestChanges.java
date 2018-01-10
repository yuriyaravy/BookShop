package ui.src.com.senla.bookshop.facade.action.other;

import backend.src.com.senla.bookshop.storage.RequestStorage;
import backend.src.com.senla.bookshop.utils.txtworker.TextSerializ;
import ui.src.com.senla.bookshop.facade.api.IAction;

public class SaveRequestChanges implements IAction{

	@Override
	public void execute() {
		TextSerializ.getInstance().textReuqestSerial(RequestStorage.getInstance().getRequestsBooks());
	}

}
