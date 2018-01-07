package by.home.book.fasade;

import by.home.book.DAO.TextDeserializ;
import by.home.book.DAO.TextSerializ;
import by.home.book.base.Book;
import by.home.book.base.Main;
import by.home.book.fasade.action.other.SaveBookChanges;
import by.home.book.repository.BookManager;

public class MainBookMenu {

	public static void main(String[] args) {
//		Main.booklist();
//		Main.requestList();
		

		MenuController mc = new MenuController();
		mc.run();
		
	}
}
