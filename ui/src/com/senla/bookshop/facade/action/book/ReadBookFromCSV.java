package ui.src.com.senla.bookshop.facade.action.book;

import backend.src.com.senla.bookshop.facade.Facade;
import backend.src.com.senla.bookshop.utils.csvworker.PathStorage;
import backend.src.com.senla.bookshop.utils.csvworker.ReadFromCSV;
import ui.src.com.senla.bookshop.facade.api.IAction;

public class ReadBookFromCSV implements IAction{

	@Override
	public void execute() {
		System.out.println(Facade.getInstance().readBookFromCSV());
		
	}

}
