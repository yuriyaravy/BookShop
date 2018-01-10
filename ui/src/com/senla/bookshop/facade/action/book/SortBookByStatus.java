package ui.src.com.senla.bookshop.facade.action.book;

import java.util.Collections;

import backend.src.com.senla.bookshop.controllers.BookManager;
import backend.src.com.senla.bookshop.entities.Book;
import backend.src.com.senla.bookshop.storage.BookStorage;
import backend.src.com.senla.bookshop.utils.comparators.book.ComparatorBookByStatus;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;

public class SortBookByStatus implements IAction{
	
	@Override
	public void execute() {
		Collections.sort(BookStorage.getInstance().getBooks(), new ComparatorBookByStatus());
		Printers.show(BookStorage.getInstance().getBooks());
	}

}
