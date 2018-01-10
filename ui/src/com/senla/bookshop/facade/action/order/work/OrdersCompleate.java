package ui.src.com.senla.bookshop.facade.action.order.work;

import backend.src.com.senla.bookshop.facade.Facade;
import backend.src.com.senla.bookshop.utils.exceptions.Setting;
import ui.src.com.senla.bookshop.facade.api.IAction;

public class OrdersCompleate implements IAction{
	
	boolean allow = Setting.isOrderCompleate();

	@Override
	public void execute() {
		if(!allow){
			Facade.getInstance().allOrderCompleate();
		}else{
			System.out.println("You can't do it maybe you don't have permit");
		}
	}

}
