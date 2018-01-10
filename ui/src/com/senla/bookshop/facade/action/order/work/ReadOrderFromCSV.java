package ui.src.com.senla.bookshop.facade.action.order.work;

import backend.src.com.senla.bookshop.facade.Facade;
import ui.src.com.senla.bookshop.facade.api.IAction;

public class ReadOrderFromCSV implements IAction{
	
	@Override
	public void execute() {
		System.out.println(Facade.getInstance().readOrderFromCSV());
		
	}

}
