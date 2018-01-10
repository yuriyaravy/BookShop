package ui.src.com.senla.bookshop.facade.action.order.work;

import backend.src.com.senla.bookshop.utils.csvworker.PathStorage;
import backend.src.com.senla.bookshop.utils.csvworker.ReadFromCSV;
import ui.src.com.senla.bookshop.facade.api.IAction;

public class ReadOrderFromCSV implements IAction{
	
	@Override
	public void execute() {
		System.out.println(ReadFromCSV.readCSV(new PathStorage().getCsvOrderFile()));
		
	}

}
