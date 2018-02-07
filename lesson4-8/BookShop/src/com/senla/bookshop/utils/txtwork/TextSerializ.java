package com.senla.bookshop.utils.txtwork;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.utils.setting.Setting;


public class TextSerializ {
	
	private static final Logger logger = Logger.getLogger(TextSerializ.class);

	public static void textSerialize(List<?> object, String key){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Setting.getPath(key)))){
			oos.writeObject(object);
		}catch(Exception e){
			logger.error(e);
		}
	}
	
	
}
