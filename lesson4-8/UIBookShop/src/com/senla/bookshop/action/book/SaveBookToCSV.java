package com.senla.bookshop.action.book;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.storage.BookStorage;
import com.senla.bookshop.utils.Printers;
import com.senla.bookshop.utils.Scanners;
import com.senla.bookshop.utils.csvwork.SaveObjectToCSV;

public class SaveBookToCSV implements IAction{

	@Override
	public void execute() {
		Facade.getInstance().saveBookToCSV();
	}

}
