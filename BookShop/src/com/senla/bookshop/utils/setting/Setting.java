package com.senla.bookshop.utils.setting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


public class Setting {
	
	private static final Logger logger = Logger.getLogger(Setting.class);
	
	private static Setting instance;
	
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
		try (FileInputStream in = new FileInputStream("files/files/property/propConfig.property")){
		Properties properties = new Properties();
		properties.load(in);
		resualt = Boolean.parseBoolean(properties.getProperty("resualt"));
		}catch (FileNotFoundException  e) {
			logger.error("FileNotFoundException, you lost your txt file" + e);
		}catch (IOException e) {
			logger.error(e);
		}
		return resualt;
	}
	
	private static int getMonthResualt(){
		int resualt = 0;
		try (FileInputStream in = new FileInputStream("files/files/property/propConfig.property")){
		Properties properties = new Properties();
		properties.load(in);
		resualt = Integer.parseInt(properties.getProperty("month"));
		}catch (FileNotFoundException  e) {
			logger.error("FileNotFoundException, you lost your txt file" + e);
		}catch (IOException e) {
			logger.error(e);
		}
		return resualt;
	}
	
	public static String getPath(String key){
		String path = null;
		try (FileInputStream in = new FileInputStream("files/files/property/pathStorage.txt")){
		Properties properties = new Properties();
		properties.load(in);
		path = properties.getProperty(key);
		System.out.println(key);
		}catch (FileNotFoundException  e) {
			logger.error("FileNotFoundException, you lost your txt file" + e);
		}catch (IOException e) {
			logger.error(e);
		}
		return path;
	}
	

}
