package ui.src.com.senla.bookshop.facade.menu;

import backend.src.com.senla.bookshop.utils.ArrayWorker;
import ui.src.com.senla.bookshop.facade.utils.Choice;

public class MenuController {
	
	private Navigator navigator;
	private Builder builder;
	private boolean exit = true;

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	public void run(){
		ArrayWorker.fillUpAllArray();
		builder = new Builder();
		builder.buildMenu();
		navigator = new Navigator (builder.getRootMenu());
		while(exit){
			navigator.printMenu();
			int where = Choice.getInput();
			navigator.navigate(where-1);
		}
	}

}
