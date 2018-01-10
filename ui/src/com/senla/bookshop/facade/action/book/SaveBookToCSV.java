package ui.src.com.senla.bookshop.facade.action.book;

import backend.src.com.senla.bookshop.storage.BookStorage;
import backend.src.com.senla.bookshop.utils.csvworker.SaveObjectToCSV;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;
import ui.src.com.senla.bookshop.facade.utils.Scanners;

public class SaveBookToCSV implements IAction{

	@Override
	public void execute() {
		Printers.show(BookStorage.getInstance().getBooks());
		SaveObjectToCSV.bookWriteToCSV(Scanners.scannerForInteger());
	}

}
