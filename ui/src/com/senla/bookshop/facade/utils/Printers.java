package ui.src.com.senla.bookshop.facade.utils;

import java.util.ArrayList;

import ui.src.com.senla.bookshop.facade.menu.MenuItem;

public class Printers {
	
	public static void show(Object string) {
		System.out.println(string);
	}

	public static void show(ArrayList<?> list) {
		for (Object string : list) {
			show(string);
		}
	}
	
	public static void showMenu(ArrayList<MenuItem> items) {
		for (int i = 0; i < items.size(); i++) {
			show((i) + "- " + items.get(i).getTitle());
		}
	}
}
