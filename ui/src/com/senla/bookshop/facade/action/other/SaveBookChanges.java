package ui.src.com.senla.bookshop.facade.action.other;

import backend.src.com.senla.bookshop.controllers.BookManager;
import backend.src.com.senla.bookshop.storage.BookStorage;
import backend.src.com.senla.bookshop.utils.txtworker.TextSerializ;
import ui.src.com.senla.bookshop.facade.api.IAction;

public class SaveBookChanges implements IAction{

	@Override
	public void execute() {
		TextSerializ.getInstance().textBookSerial(BookStorage.getInstance().getBooks());
		
	}

}
