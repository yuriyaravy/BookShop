package by.home.book.fasade.action.request;

import by.home.book.DAO.CSV.SaveObjectToCSV;
import by.home.book.fasade.IAction;
import by.home.book.instruments.Scanners;
import by.home.book.repository.RequestManager;

public class SaveRequestToCSV implements IAction{

	@Override
	public void execute() {
		RequestManager.showAllRequests();
		SaveObjectToCSV.requestWriteToCSV(Scanners.scannerForInteger());
	}
}
