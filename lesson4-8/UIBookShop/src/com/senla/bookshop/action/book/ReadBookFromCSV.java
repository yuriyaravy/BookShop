package com.senla.bookshop.action.book;
import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;

public class ReadBookFromCSV implements IAction{

	@Override
	public void execute() {
		if(Facade.getInstance().readBookFromCSV()){
			Printers.show("Done");
		}else{
			Printers.show("Fail, something wrong");
		}
		
	}

}
