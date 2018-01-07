package by.home.book.fasade.action.request;

import by.home.book.fasade.IAction;
import by.home.book.instruments.Scanners;
import by.home.book.repository.BookManager;
import by.home.book.repository.RequestManager;

public class AddNewRequest implements IAction{

	@Override
	public void execute() {
		BookManager.showAllBooks();
		System.out.println("what book do you want request");
		RequestManager.addRequest(Scanners.scannerForInteger());
	}

}
