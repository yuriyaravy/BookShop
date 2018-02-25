package com.senla.bookshop.utils;

import java.util.List;

import com.senla.bookshop.menu.MenuItem;

public class Printers {
	
	public static void show(Object string) {
		System.out.println(string);
	}

	public static void show(List<?> list) {
		for (Object string : list) {
			System.out.println(string);
		}
	}
	
	public static void showMenu(List<MenuItem> items) {
		for (int i = 0; i < items.size(); i++) {
			show((i) + "- " + items.get(i).getTitle());
		}
	}
}
