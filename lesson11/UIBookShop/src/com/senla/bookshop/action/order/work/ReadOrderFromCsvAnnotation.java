package com.senla.bookshop.action.order.work;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class ReadOrderFromCsvAnnotation implements IAction{
	
	@Override
	public void execute() {
		try {
			Facade.getInstance().orderAnnotationFromCSV();
		} catch (Exception e) {
			Printers.show("Failed to get orders from CSV");
		}
	}

}
