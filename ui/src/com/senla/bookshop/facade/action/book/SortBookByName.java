package ui.src.com.senla.bookshop.facade.action.book;

import java.util.Collections;

import backend.src.com.senla.bookshop.facade.Facade;
import backend.src.com.senla.bookshop.storage.BookStorage;
import backend.src.com.senla.bookshop.utils.comparators.book.ComparatorBookByName;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;


public class SortBookByName implements IAction{
	
	@Override
	public void execute() {
		Printers.show(Facade.getInstance().sortBookByName());
	}

}
