package com.senla.bookshop.action.book;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;


public class SortBookByPublicYear implements IAction{

	@Override
	public void execute() {
		Printers.show(Facade.getInstance().sortBookByYearOfPublic());
	}

}
