package by.home.book.services.comparators.order;

import java.util.Comparator;

import by.home.book.base.Order;
import by.home.book.base.OrderStatus;

public class ComparatorOrderBydateOfCompleate implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		if(o1.getStatus() == OrderStatus.COMPLEATE && o2.getStatus() == OrderStatus.COMPLEATE){
			return o1.getDateOfDeliver().compareTo(o2.getDateOfDeliver());
		}else{
			return 0;
		}
	}

}
