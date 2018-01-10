package ui.src.com.senla.bookshop.facade.action.other;

import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.menu.MenuController;

public class SaveChanges implements IAction{

	@Override
	public void execute() {
		MenuController mc = new MenuController();
		mc.setExit(false);
	}

}
