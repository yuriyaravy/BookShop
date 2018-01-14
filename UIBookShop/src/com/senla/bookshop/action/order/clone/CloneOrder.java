package com.senla.bookshop.action.order.clone;


import org.apache.log4j.Logger;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;
import com.senla.bookshop.utils.Scanners;

public class CloneOrder implements IAction{
	
	private static final Logger logger = Logger.getLogger(CloneOrder.class);

	@Override
	public void execute() {
		Printers.show(Facade.getInstance().getOrders());
		System.out.println("Select order by id for clone: ");
		if(Facade.getInstance().cloneOrder(Facade.getInstance().getOrderById(Scanners.scannerForInteger()))){
			System.out.println("Clonning compleate");
		}else{
			System.out.println("Fail");
		}
	}
	
	
	
	
}
