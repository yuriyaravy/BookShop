package com.senla.bookshop.action.book;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class ReadBookFromCsvAnnotation implements IAction{

	@Override
	public void execute() {
		try {
			Facade.getInstance().booksAnnotationFromCSV();
		} catch (Exception e) {
			Printers.show("Could not get books by annotation from CSV");
		}
		
	}

}
