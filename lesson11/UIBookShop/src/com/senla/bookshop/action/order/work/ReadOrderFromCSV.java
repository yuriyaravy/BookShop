package com.senla.bookshop.action.order.work;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class ReadOrderFromCSV implements IAction{
	
	@Override
	public void execute() {
		if(Facade.getInstance().readObjectFromCSV() != null){
			Printers.show("Done");
		}else{
			Printers.show("Fail, something wrong");
		}
	}

}
