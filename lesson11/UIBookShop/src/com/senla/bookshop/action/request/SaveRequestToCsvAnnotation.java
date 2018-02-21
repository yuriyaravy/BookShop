package com.senla.bookshop.action.request;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class SaveRequestToCsvAnnotation implements IAction{

	@Override
	public void execute() {
		try {
			Facade.getInstance().requestAnnotationToCSV();
		} catch (Exception e) {
			Printers.show("Could not save request by annotation to CSV");
		}
	}
}
