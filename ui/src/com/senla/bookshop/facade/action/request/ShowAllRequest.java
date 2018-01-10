package ui.src.com.senla.bookshop.facade.action.request;

import backend.src.com.senla.bookshop.controllers.RequestManager;
import backend.src.com.senla.bookshop.storage.RequestStorage;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;

public class ShowAllRequest implements IAction{

	@Override
	public void execute() {
		Printers.show(RequestStorage.getInstance().getRequestsBooks());
	}

}
