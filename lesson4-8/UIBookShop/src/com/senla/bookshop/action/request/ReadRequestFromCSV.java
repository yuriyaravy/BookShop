package com.senla.bookshop.action.request;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;

public class ReadRequestFromCSV implements IAction{

	@Override
	public void execute() {
		if(Facade.getInstance().readRequestFromCSV()){
			System.out.println("Done");
		}else{
			System.out.println("Fail, something wrong");
		}
		
	}

}
