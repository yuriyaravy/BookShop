package com.senla.bookshop.action.order.work;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printers;
import com.senla.bookshop.utils.setting.Setting;

public class OrderAllCompleate implements IAction{
	
	boolean allow = Setting.isOrderCompleate();

	@Override
	public void execute() {
		if(!allow){
			Facade.getInstance().allOrderCompleate();
		}else{
			Printers.show("You can't do it maybe you don't have permit");
		}
	}

}
