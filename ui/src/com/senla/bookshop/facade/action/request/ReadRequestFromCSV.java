package ui.src.com.senla.bookshop.facade.action.request;

import backend.src.com.senla.bookshop.facade.Facade;
import ui.src.com.senla.bookshop.facade.api.IAction;

public class ReadRequestFromCSV implements IAction{

	@Override
	public void execute() {
		System.out.println(Facade.getInstance().readRequestFromCSV());
		
	}

}
