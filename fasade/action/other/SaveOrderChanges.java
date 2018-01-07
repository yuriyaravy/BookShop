package by.home.book.fasade.action.other;

import by.home.book.DAO.TextSerializ;
import by.home.book.fasade.IAction;
import by.home.book.repository.OrderManager;

public class SaveOrderChanges implements IAction{

	@Override
	public void execute() {
		TextSerializ.getInstance().textOrderSerial(OrderManager.orderBooks);
		
	}

}
