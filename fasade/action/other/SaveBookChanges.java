package by.home.book.fasade.action.other;

import by.home.book.DAO.TextDeserializ;
import by.home.book.DAO.TextSerializ;
import by.home.book.fasade.IAction;
import by.home.book.repository.BookManager;

public class SaveBookChanges implements IAction{

	@Override
	public void execute() {
		TextSerializ.getInstance().textBookSerial(BookManager.books);
		
	}

}
