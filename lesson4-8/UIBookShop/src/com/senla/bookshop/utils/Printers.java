package com.senla.bookshop.utils;

import java.util.ArrayList;

import com.senla.bookshop.menu.MenuItem;

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
