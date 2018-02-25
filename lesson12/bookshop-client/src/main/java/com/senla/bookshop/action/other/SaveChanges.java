package com.senla.bookshop.action.other;

import com.senla.bookshop.api.IAction;
import com.senla.bookshop.menu.MenuController;

public class SaveChanges implements IAction{

	@Override
	public void execute() {
		MenuController mc = new MenuController();
		mc.setExit(false);
	}

}
