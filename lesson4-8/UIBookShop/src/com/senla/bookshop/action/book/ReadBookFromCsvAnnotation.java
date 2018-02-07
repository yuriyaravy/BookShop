package com.senla.bookshop.action.book;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class ReadBookFromCsvAnnotation implements IAction{

	@Override
	public void execute() {
		if(Facade.getInstance().booksAnnotationFromCSV()){
			Printers.show("You are get books from SCV file with using annotation");
		}else{
			Printers.show("Fail, no books no honey");
		}
	}

}
