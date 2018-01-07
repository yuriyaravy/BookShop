package by.home.book.fasade.action.other;

import by.home.book.fasade.IAction;
import by.home.book.fasade.MenuController;

public class SaveChanges implements IAction{

	@Override
	public void execute() {
		MenuController mc = new MenuController();
		mc.setExit(false);
	}

}
