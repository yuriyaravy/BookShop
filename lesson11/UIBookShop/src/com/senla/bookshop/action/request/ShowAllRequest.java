package com.senla.bookshop.action.request;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class ShowAllRequest implements IAction{

	@Override
	public void execute() {
		try {
			Printers.show(Facade.getInstance().getAllRequest());
		} catch (Exception e) {
			Printers.show("Errors program can't show all requests");
		}
	}

}
