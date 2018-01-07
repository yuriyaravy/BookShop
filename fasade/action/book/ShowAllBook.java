package by.home.book.fasade.action.book;

import by.home.book.base.Book;
import by.home.book.fasade.IAction;
import by.home.book.repository.BookManager;

public class ShowAllBook implements IAction{

	@Override
	public void execute() {
		for(Book temp : BookManager.books){
			System.out.println(temp);
		}
		
	}

}
