package backend.src.com.senla.bookshop.utils.comparators.order;

import java.util.Comparator;

import backend.src.com.senla.bookshop.entities.Order;


public class ComparatorOrderByDate implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		if(o1 != null && o2 != null) {
			if (o1.getDateOfDeliver().before(o2.getDateOfDeliver())) {
				return -1;
			} else if (o1.getDateOfDeliver().after(o2.getDateOfDeliver())) {
				return 1;
			} else {
				return 0;
			}       
		} else if (o1 != null && o2 == null) {
			return 1;
		} else {
			return -1;
		}		
	}

}
