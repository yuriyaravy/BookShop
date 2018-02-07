package com.senla.bookshop.utils.txtwork;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.utils.setting.Setting;


public class TextDeserializ {
	
	private static final Logger logger = Logger.getLogger(TextDeserializ.class);

	public List<?> textDeserialez(String key){
		List<?> object = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Setting.getPath(key)))){
			object =  (List<?>) ois.readObject();
		} catch (ClassNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		return object;
	}
	
	
}
