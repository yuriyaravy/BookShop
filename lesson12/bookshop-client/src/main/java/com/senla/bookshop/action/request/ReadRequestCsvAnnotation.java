package com.senla.bookshop.action.request;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class ReadRequestCsvAnnotation implements IAction{
	
	@Override
	public void execute() {
		try{
			Facade.getInstance().requestAnnotationFromCSV();
		} catch (Exception e) {
			Printers.show("Failed to read request from CSV by annotation");
		}
	}

}
