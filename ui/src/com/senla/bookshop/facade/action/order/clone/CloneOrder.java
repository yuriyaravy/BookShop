package ui.src.com.senla.bookshop.facade.action.order.clone;


import org.apache.log4j.Logger;

import backend.src.com.senla.bookshop.facade.Facade;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;
import ui.src.com.senla.bookshop.facade.utils.Scanners;

public class CloneOrder implements IAction{
	
	private static final Logger logger = Logger.getLogger(CloneOrder.class);

	@Override
	public void execute() {
		Printers.show(Facade.getInstance().getOrders());
		System.out.println("Select order by id for clone: ");
		Facade.getInstance().cloneOrder(Facade.getInstance().getOrderById(Scanners.scannerForInteger()));
	}
	
	
	
	
}
