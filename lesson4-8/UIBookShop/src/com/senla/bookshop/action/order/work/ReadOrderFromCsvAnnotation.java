package com.senla.bookshop.action.order.work;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class ReadOrderFromCsvAnnotation implements IAction{
	
	@Override
	public void execute() {
		if(Facade.getInstance().OrderAnnotationFromCSV()){
			Printers.show("You are get orders from SCV file with using annotation");
		}else{
			Printers.show("Fail, no orders no honey");
		}
	}

}
