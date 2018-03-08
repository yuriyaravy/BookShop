package com.senla.bookshop.action.request;


import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class RequestByPrice implements IAction{
	
	@Override
	public void execute() {
		try {
			Printers.show(Facade.getInstance().sortRequestAmounte());
		} catch (Exception e) {
			Printers.show("Can not sort by amounte");
		}
	}
}
