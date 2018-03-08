package com.senla.bookshop.action.book;


import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class SortBookByName implements IAction{
	
	@Override
	public void execute() {
		try {
			Printers.show(Facade.getInstance().sortBookByName());
		} catch (Exception e) {
			Printers.show("Failed to display books sorted by name");
		}
	}

}
