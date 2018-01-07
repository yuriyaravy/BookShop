package by.home.book.fasade.action.book;

import java.util.Collections;

import by.home.book.base.Book;
import by.home.book.fasade.IAction;
import by.home.book.repository.BookManager;
import by.home.book.services.comparators.book.ComparatorBookByStatus;

public class SortBookByStatus implements IAction{
	
	@Override
	public void execute() {
		Collections.sort(BookManager.books, new ComparatorBookByStatus());
		for(Book temp : (BookManager.books)){
			System.out.println(temp);
		}
	}

}
