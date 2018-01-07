package by.home.book.services.comparators.book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import by.home.book.DAO.TextLogger;
import by.home.book.base.Book;

public class ComparatorBookByDate implements Comparator<Book>{
	
	
	@Override
	public int compare(Book o1, Book o2) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date o1PublishDate = null;
        Date o2PublishDate = null;
        try {
            o1PublishDate = formatter.parse(o1.getDate());
            o2PublishDate = formatter.parse(o2.getDate());
        } catch (ParseException pe) {
            TextLogger.exceptLog(pe);
        }
        return o1PublishDate.compareTo(o2PublishDate);
	}
}
