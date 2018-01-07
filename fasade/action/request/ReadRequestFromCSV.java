package by.home.book.fasade.action.request;

import by.home.book.DAO.CSV.PathStorage;
import by.home.book.DAO.CSV.ReadFromCSV;
import by.home.book.fasade.IAction;

public class ReadRequestFromCSV implements IAction{

	@Override
	public void execute() {
		System.out.println(ReadFromCSV.readCSV(new PathStorage().getCsvRequestFile()));
		
	}

}
