package ui.src.com.senla.bookshop.facade.action.order.work;

import backend.src.com.senla.bookshop.facade.Facade;
import backend.src.com.senla.bookshop.utils.exceptions.Setting;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Scanners;

public class OrderCompleate implements IAction{

	boolean allow = Setting.isOrderCompleate();
	
	@Override
	public void execute() {
		if(!allow){
			Facade.getInstance().orderCompleate(Scanners.scannerForInteger());
		}else{
			System.out.println("You can't do it maybe you don't have permit");
		}
	}

}
