package ui.src.com.senla.bookshop.facade.action.order.clone;

import java.util.Scanner;

import org.apache.log4j.Logger;

import backend.src.com.senla.bookshop.controllers.OrderManager;
import backend.src.com.senla.bookshop.entities.Order;
import backend.src.com.senla.bookshop.enums.OrderStatus;
import backend.src.com.senla.bookshop.facade.Facade;
import backend.src.com.senla.bookshop.storage.OrderStorage;
import backend.src.com.senla.bookshop.utils.DateManager;
import backend.src.com.senla.bookshop.utils.txtworker.TextSerializ;
import ui.src.com.senla.bookshop.facade.api.IAction;
import ui.src.com.senla.bookshop.facade.utils.Printers;
import ui.src.com.senla.bookshop.facade.utils.Scanners;

public class CloneOrder implements IAction{
	
	private static final Logger logger = Logger.getLogger(CloneOrder.class);

	@Override
	public void execute() {
		
		Printers.show(OrderStorage.getInstance().getOrdersBooks());
		System.out.println("Select order by id: ");
		Order order = Facade.getInstance().getOrderById(Scanners.scannerForInteger());
		Scanner input = new Scanner(System.in);
		System.out.println("Enter how many books will be in your order: ");
		int size = input.nextInt();
		int array[] = new int[size];
		System.out.println("Insert id books:");
		for (int i = 0; i < size; i++){
			array[i] = input.nextInt();
		}
		System.out.println("Enter status can be (COMPLEATE, CANCELED, PROCESSING)");
		OrderStatus value = OrderStatus.valueOf(input.next().toUpperCase());
		Order copyOrder = null;
		try{
			copyOrder = order.clone();
			copyOrder.setBookId(array);
			copyOrder.setStatus(value);
			if(value == OrderStatus.COMPLEATE){
				copyOrder.setDateOfDeliver(DateManager.setDate());
			}
			OrderStorage.getInstance().getOrdersBooks().add(copyOrder);
			TextSerializ.getInstance().textOrderSerial(OrderStorage.getInstance().getOrdersBooks());
		}catch(CloneNotSupportedException ex){
			logger.error(ex);
		}
		
	}
	
	
	
	
}
