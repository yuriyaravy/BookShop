package by.home.book.fasade;

import java.util.ArrayList;

public class Menu {
	
	private String name;
	private ArrayList<MenuItem> menuItems = new ArrayList<>();
	
	public Menu() {
	}
	
	public Menu(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<MenuItem> getMenuItem() {
		return menuItems;
	}
	
	public void setMenuItem(ArrayList<MenuItem> menuItem) {
		this.menuItems = menuItem;
	}
	
	public void addMenu(MenuItem menuItem){
		menuItems.add(menuItem);
	}
}
