package com.senla.bookshop.menu;

import com.senla.bookshop.utils.Choice;

public class MenuController {
	
	private Navigator navigator;
	private Builder builder;
	private boolean exit = false;

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	public void run(){
		builder = new Builder();
		builder.buildMenu();
		navigator = new Navigator (builder.getRootMenu());
		while(!exit){
			navigator.printMenu();
			int where = Choice.getInput();
			navigator.navigate(where-1);
		}
	}

}
