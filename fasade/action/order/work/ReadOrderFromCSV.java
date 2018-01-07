package by.home.book.fasade.action.order.work;

import by.home.book.DAO.CSV.PathStorage;
import by.home.book.DAO.CSV.ReadFromCSV;
import by.home.book.fasade.IAction;

public class ReadOrderFromCSV implements IAction{
	
	@Override
	public void execute() {
		System.out.println(ReadFromCSV.readCSV(new PathStorage().getCsvOrderFile()));
		
	}

}
