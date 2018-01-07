package by.home.book.fasade.action.order.work;

import by.home.book.base.Order;
import by.home.book.fasade.IAction;
import by.home.book.repository.OrderManager;

public class CheckOrders implements IAction{

	@Override
	public void execute() {
		for(Order temp : OrderManager.orderBooks){
			System.out.println(temp);
		}
		
	}

}
