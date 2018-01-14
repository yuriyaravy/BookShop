package com.senla.bookshop.action.book;

import java.util.Collections;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.storage.BookStorage;
import com.senla.bookshop.utils.Printers;
import com.senla.bookshop.utils.comparators.book.ComparatorBookByName;


public class SortBookByName implements IAction{
	
	@Override
	public void execute() {
		Printers.show(Facade.getInstance().sortBookByName());
	}

}
