package backend.src.com.senla.bookshop.utils.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


public class Setting {
	
	private static final Logger logger = Logger.getLogger(Setting.class);
	
	private static Setting instance;
	
	private static int month = getMonthResualt();
	
	private static boolean orderCompleate = getturnOnOffOrder();

	public static int getMonth() {
		return month;
	}
	public static void setMonth(int month) {
		Setting.month = month;
	}
	public static boolean isOrderCompleate() {
		return orderCompleate;
	}
	public static void setOrderCompleate(boolean orderCompleate) {
		Setting.orderCompleate = orderCompleate;
	}
	private static boolean getturnOnOffOrder(){
		boolean resualt = false;
		try {
		Properties properties = new Properties();
		FileInputStream in = new FileInputStream("/BookShop/src/file/com/senla/bookshop/files/property/propConfig.txt");
		properties.load(in);
		resualt = Boolean.parseBoolean(properties.getProperty("resualt"));
		}catch (FileNotFoundException  e) {
			System.out.println("FileNotFoundException, you lost your txt file");
			logger.error(e);
		}catch (IOException e) {
			logger.error(e);
		}
		return resualt;
	}
	
	private static int getMonthResualt(){
		int resualt = 0;
		try {
		Properties properties = new Properties();
		FileInputStream in = new FileInputStream("/BookShop/src/file/com/senla/bookshop/files/property/propConfig.txt");
		properties.load(in);
		resualt = Integer.parseInt(properties.getProperty("month"));
		}catch (FileNotFoundException  e) {
			System.out.println("FileNotFoundException, you lost your txt file");
			logger.error(e);
		}catch (IOException e) {
			logger.error(e);
		}
		return resualt;
	}
	
	private Setting (){
	}
	
	public static Setting getInstance(){
		if(instance == null){
			synchronized (Setting.class) {
				if(instance == null)
					instance = new Setting();
			}
		}
		return instance;
	}

}
