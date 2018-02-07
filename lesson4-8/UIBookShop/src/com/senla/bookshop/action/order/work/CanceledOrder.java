package com.senla.bookshop.action.order.work;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;
import com.senla.bookshop.utils.Scanners;

public class CanceledOrder implements IAction{

	@Override
	public void execute() {
		Printers.show(Facade.getInstance().getOrders());
		Printers.show("Write order id for canceled this order");
		if(Facade.getInstance().cancelOrder(Scanners.scannerForInteger())){
			Printers.show("Your order was canceled");
		}else{
			Printers.show("Fail, something wrong");
		}
	}
		
}


