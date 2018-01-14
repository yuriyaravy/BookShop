package com.senla.bookshop.action.order.work;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;
import com.senla.bookshop.utils.Scanners;

public class CanceledOrder implements IAction{

	@Override
	public void execute() {
		Printers.show(Facade.getInstance().getOrders());
		System.out.println();
		System.out.println("Write order id for canceled this order");
		if(Facade.getInstance().cancelOrder(Scanners.scannerForInteger())){
			System.out.println("Your order was canceled");
		}else{
			System.out.println("Fail, something wrong");
		}
	}
		
}


