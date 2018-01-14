package com.senla.bookshop.action.order.work;

import java.util.List;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Scanners;

public class AddOrder implements IAction{

	@Override
	public void execute() {
		System.out.println("write books id which you want to add to order");
		Book book = Facade.getInstance().getBookById(Scanners.scannerForInteger());
		if(Facade.getInstance().addBookToOrder((List<Book>) book)){
			System.out.println("Your order was add");
		}else{
			System.out.println("Fail, something wrong");
		}
	}

}
