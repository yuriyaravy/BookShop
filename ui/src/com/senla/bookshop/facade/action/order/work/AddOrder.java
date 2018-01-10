package ui.src.com.senla.bookshop.facade.action.order.work;

import backend.src.com.senla.bookshop.facade.Facade;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Scanners;

public class AddOrder implements IAction{

	@Override
	public void execute() {
		System.out.println("write books id which you want to add to order");
		int[] bookId = {Scanners.scannerForInteger()};
		Facade.getInstance().addBookToOrder(bookId);
	}

}
