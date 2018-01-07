package by.home.book.fasade.action.book;

import by.home.book.DAO.CSV.SaveObjectToCSV;
import by.home.book.fasade.IAction;
import by.home.book.instruments.Scanners;
import by.home.book.repository.BookManager;

public class SaveBookToCSV implements IAction{

	@Override
	public void execute() {
		BookManager.showAllBooks();
		SaveObjectToCSV.bookWriteToCSV(Scanners.scannerForInteger());
	}

}
