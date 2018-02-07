package com.senla.bookshop.action.request;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class ReadRequestCsvAnnotation implements IAction{
	
	@Override
	public void execute() {
		if(Facade.getInstance().requestAnnotationFromCSV()){
			Printers.show("You are get requests from SCV file with using annotation");
		}else{
			Printers.show("Fail, no request no honey");
		}
	}

}
