package ui.src.com.senla.bookshop.facade.action.book;

import backend.src.com.senla.bookshop.storage.BookStorage;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;

public class ShowAllBook implements IAction{

	@Override
	public void execute() {
		Printers.show(BookStorage.getInstance().getBooks());
		
	}

}
