package com.senla.bookshop.action.book;
import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;

public class ReadBookFromCSV implements IAction{

	@Override
	public void execute() {
		if(Facade.getInstance().readBookFromCSV()){
			System.out.println("Done");
		}else{
			System.out.println("Fail, something wrong");
		}
		
	}

}
