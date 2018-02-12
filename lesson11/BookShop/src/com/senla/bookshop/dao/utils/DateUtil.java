package com.senla.bookshop.dao.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static final String DATE_PATTERN = "dd-MM-yyyy";
	private static final SimpleDateFormat format = new SimpleDateFormat();
	private static DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);

	static {
		format.applyPattern(DATE_PATTERN);
	}

	public static final Date parserDateFromString(String dateString) {

		try {
			return format.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	public static final String parserStringFromDate(Date date) {
		if(date==null){
			return null;
		}else{
			return dateFormat.format(date);
		}
	}

}
