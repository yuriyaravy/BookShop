package by.home.book.fasade.action.other;

import by.home.book.DAO.TextSerializ;
import by.home.book.fasade.IAction;
import by.home.book.repository.RequestManager;

public class SaveRequestChanges implements IAction{

	@Override
	public void execute() {
		TextSerializ.getInstance().textReuqestSerial(RequestManager.requestBooks);
	}

}
