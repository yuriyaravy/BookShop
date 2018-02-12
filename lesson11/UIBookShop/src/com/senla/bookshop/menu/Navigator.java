package com.senla.bookshop.menu;

import java.util.ArrayList;


public class Navigator {
	
	Menu currentMenu;
	
	public Navigator(Menu currentMenu) {
		this.currentMenu = currentMenu;
	}

	public void printMenu(){ 
		int counter = 0;
		ArrayList<MenuItem> items = currentMenu.getMenuItem();
		for(MenuItem temp : items){
			counter++;
			String title = temp.getTitle();
			System.out.println(counter + " - " +title);
		}
	}
	public void navigate(Integer index){
		ArrayList<MenuItem> items = currentMenu.getMenuItem();
		MenuItem item = items.get(index);
		if (item.getAction() != null){
			item.doAction();
		} else {
			currentMenu = item.getNextMenu();
		}
		
	}
}
