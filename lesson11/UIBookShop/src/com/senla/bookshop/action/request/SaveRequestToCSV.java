package com.senla.bookshop.action.request;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;
import com.senla.bookshop.utils.Scanners;

public class SaveRequestToCSV implements IAction{

	@Override
	public void execute() {
		Facade.getInstance().requestAnnotationFromCSV();
	}
}
