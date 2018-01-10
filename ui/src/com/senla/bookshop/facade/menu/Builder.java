package ui.src.com.senla.bookshop.facade.menu;

import ui.src.com.senla.bookshop.facade.action.book.*;
import ui.src.com.senla.bookshop.facade.action.order.clone.CloneOrder;
import ui.src.com.senla.bookshop.facade.action.order.sortings.*;
import ui.src.com.senla.bookshop.facade.action.order.statistic.*;
import ui.src.com.senla.bookshop.facade.action.order.work.*;
import ui.src.com.senla.bookshop.facade.action.other.*;
import ui.src.com.senla.bookshop.facade.action.request.*;

public class Builder {
	
	private Menu mainMenu = new Menu();
	private Menu bookMenu = new Menu();
	private Menu orderMenu = new Menu();
	private Menu orderSort = new Menu();
	private Menu orderStatistic = new Menu();
	private Menu orderWork = new Menu();
	private Menu requestMenu = new Menu();
	
	
	public Menu buildMenu(){
		
		orderWork.addMenu(new MenuItem("Show all orders",new CheckOrders()));
		orderWork.addMenu(new MenuItem("Add book to storage",new OrderCompleate()));
		orderWork.addMenu(new MenuItem("Add order",new AddOrder()));
		orderWork.addMenu(new MenuItem("Delete order",new DeleteOrder()));
		orderWork.addMenu(new MenuItem("Canceled orders",new CanceledOrder()));
		orderWork.addMenu(new MenuItem("Save order", new SaveOrderChanges()));
		orderWork.addMenu(new MenuItem("Back", orderMenu));
		
		orderSort.addMenu(new MenuItem("Sorting by date of delivered",new SortByDeliverDate()));
		orderSort.addMenu(new MenuItem("Sorting by price of order",new SortByOrderPrice()));
		orderSort.addMenu(new MenuItem("Sorting by status of order", new SortByOrderStatus()));
		orderSort.addMenu(new MenuItem("Sorting by the profit of the executed orders", new SortByPriceOfExecutOrders()));
		orderSort.addMenu(new MenuItem("Back", orderMenu));
		
		orderStatistic.addMenu(new MenuItem("Amount of profit", new AmountOfProfit()));
		orderStatistic.addMenu(new MenuItem("Amount of order", new AmountOfOrder()));
		orderStatistic.addMenu(new MenuItem("Back", orderMenu));
		
		orderMenu.addMenu(new MenuItem("Work with orders",orderWork));
		orderMenu.addMenu(new MenuItem("Order sortings",orderSort));
		orderMenu.addMenu(new MenuItem("Statistic", orderStatistic));
		orderMenu.addMenu(new MenuItem("Cloning order", new CloneOrder()));
		orderMenu.addMenu(new MenuItem("Save order to CSV file", new SaveOrderToCSV()));
		orderMenu.addMenu(new MenuItem("Read order from CSV file", new ReadOrderFromCSV()));
		orderMenu.addMenu(new MenuItem("Back",mainMenu));
		
		bookMenu.addMenu(new MenuItem("Show all books ", new ShowAllBook()));
		bookMenu.addMenu(new MenuItem("Sort books by name ", new SortBookByName()));
		bookMenu.addMenu(new MenuItem("Sort books by price ", new SortBookByPrice()));
		bookMenu.addMenu(new MenuItem("Sort books by date ", new SortBookByDate()));
		bookMenu.addMenu(new MenuItem("Sort books by status ", new SortBookByStatus()));
		bookMenu.addMenu(new MenuItem("Sort books by year of publication ", new SortBookByPublicYear()));
		bookMenu.addMenu(new MenuItem("Save book ", new SaveBookChanges()));
		bookMenu.addMenu(new MenuItem("Save book to CSV file", new SaveBookToCSV()));
		bookMenu.addMenu(new MenuItem("Read book from CSV file", new ReadBookFromCSV()));
		bookMenu.addMenu(new MenuItem("Back ", mainMenu));
		
		requestMenu.addMenu(new MenuItem("Show all requests ", new ShowAllRequest()));
		requestMenu.addMenu(new MenuItem("Add new request ", new AddNewRequest()));
		requestMenu.addMenu(new MenuItem("Save request ", new SaveRequestChanges()));
		requestMenu.addMenu(new MenuItem("Save request to CSV file", new SaveRequestToCSV()));
		requestMenu.addMenu(new MenuItem("Read request from CSV file", new ReadRequestFromCSV()));
		requestMenu.addMenu(new MenuItem("Back ", mainMenu));
		
		mainMenu.addMenu(new MenuItem("Book", bookMenu));
		mainMenu.addMenu(new MenuItem("Order", orderMenu));
		mainMenu.addMenu(new MenuItem("Request", requestMenu));
		
		return mainMenu;
	}
	
	public Menu getRootMenu(){
		return this.mainMenu;
		
	}
}
