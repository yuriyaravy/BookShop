package com.senla.bookshop.action.order.work;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;
import com.senla.bookshop.utils.Scanners;

public class DeleteOrder implements IAction{

	@Override
	public void execute() {
		Printers.show(Facade.getInstance().getOrders());
		System.out.println();
		System.out.println("Write order id for delete this order");
		if(Facade.getInstance().deleteBookToOrder(Scanners.scannerForInteger())){
			System.out.println("Your order was delete");
		}else{
			System.out.println("Fail, something wrong");
		}
	}

}
