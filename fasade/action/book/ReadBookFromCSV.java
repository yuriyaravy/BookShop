package by.home.book.fasade.action.book;

import by.home.book.DAO.CSV.PathStorage;
import by.home.book.DAO.CSV.ReadFromCSV;
import by.home.book.fasade.IAction;

public class ReadBookFromCSV implements IAction{

	@Override
	public void execute() {
		System.out.println(ReadFromCSV.readCSV(new PathStorage().getCsvBookFile()));
		
	}

}
