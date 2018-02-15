package com.senla.bookshop.action.order.work;

import java.util.List;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;
import com.senla.bookshop.utils.Scanners;

public class AddOrder implements IAction{

	@Override
	public void execute() {
		Printers.show("Select book number which do you want to add to order");
		Printers.show(Facade.getInstance().getBooks());
		Book book = Facade.getInstance().getBookById(Scanners.scannerForInteger());
		if(Facade.getInstance().addBookToOrder((List<Book>) book)){
			Printers.show("Your order was add");
		}else{
			Printers.show("Fail, something wrong");
		}
	}

}
