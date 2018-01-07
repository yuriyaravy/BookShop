package by.home.book.fasade;

import by.home.book.instruments.ArrayWorker;
import by.home.book.instruments.Choice;

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
