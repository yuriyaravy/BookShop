package by.home.book.fasade.action.order.work;

import by.home.book.base.Order;
import by.home.book.fasade.IAction;
import by.home.book.instruments.Scanners;
import by.home.book.repository.OrderManager;

public class CanceledOrder implements IAction{

	@Override
	public void execute() {
		for(Order temp : OrderManager.orderBooks){
			System.out.println(temp);
		}
		System.out.println();
		System.out.println("Write order id for canceled this order");
		OrderManager.cancelOrder(Scanners.scannerForInteger());
	}
		
}


