package by.home.book.instruments;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateManager {
	
	public static Date setDate(){	
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		return gc.getTime();
	}
	
	public static String setStringDate(){	
	//	GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date today = Calendar.getInstance().getTime();
		String strDate = format.format(today);
		return strDate;
	}

}
