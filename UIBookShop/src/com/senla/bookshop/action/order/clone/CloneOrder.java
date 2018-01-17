package com.senla.bookshop.action.order.clone;


import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;
import com.senla.bookshop.utils.Scanners;

public class CloneOrder implements IAction{
	

	@Override
	public void execute() {
		Printers.show(Facade.getInstance().getOrders());
		Printers.show("Select order by id for clone: ");
		if(Facade.getInstance().cloneOrder(Facade.getInstance().getOrderById(Scanners.scannerForInteger()))){
			Printers.show("Clonning compleate");
		}else{
			Printers.show("Fail");
		}
	}
	
	
	
	
}
