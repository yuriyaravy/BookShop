package by.home.book.fasade.action.request;

import by.home.book.fasade.IAction;
import by.home.book.repository.RequestManager;

public class ShowAllRequest implements IAction{

	@Override
	public void execute() {
		RequestManager.showAllRequests();
	}

}
