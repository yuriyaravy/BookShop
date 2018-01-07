package by.home.book.fasade.action.order.work;

import by.home.book.DAO.CSV.SaveObjectToCSV;
import by.home.book.fasade.IAction;
import by.home.book.instruments.Scanners;
import by.home.book.repository.OrderManager;

public class SaveOrderToCSV implements IAction{

	@Override
	public void execute() {
		OrderManager.showAllOrders();
		SaveObjectToCSV.orderWriteToCSV(Scanners.scannerForInteger());
	}

}
