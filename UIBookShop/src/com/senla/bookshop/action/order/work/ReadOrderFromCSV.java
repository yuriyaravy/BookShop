package com.senla.bookshop.action.order.work;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;

public class ReadOrderFromCSV implements IAction{
	
	@Override
	public void execute() {
		if(Facade.getInstance().readOrderFromCSV()){
			System.out.println("Done");
		}else{
			System.out.println("Fail, something wrong");
		}
	}

}
