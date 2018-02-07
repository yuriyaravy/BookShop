package com.senla.bookshop.utils.annotations;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.senla.bookshop.annotations.CsvProperty;

public class AnnotationCSVParser {
	
	
	public static String parseToString(Object object, String keyField) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
			if (object != null) {
					List<?> entities = (List<?>) object;
					StringBuilder strb = new StringBuilder();
					for (Object entity : entities) {
						for(Field fild : entity.getClass().getDeclaredFields()){
							if(fild.getAnnotation(CsvProperty.class).keyField().equalsIgnoreCase(keyField)){
								fild.setAccessible(true);
								strb.append(fild.get(entity)).append(",");
							}
						}
					}
					return String.valueOf(strb);
				}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static Object parseToObject(Class<?> entity, String[] cutLine) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException{
		Constructor constructor = null;
		System.out.println(cutLine.length);
		for(Constructor tempConst : entity.getConstructors()){
			System.out.println(tempConst.getParameterCount());
			if(tempConst.getParameterCount() == cutLine.length)
				constructor = tempConst;
		}
		if(constructor != null){
			Class[] constParameters = constructor.getParameterTypes();
			Field[] entityFields = entity.getDeclaredFields();
			List parameters = new ArrayList();
			for(int i = 0; i < cutLine.length; i++){
				List parsed = getObjectFromSCV(constParameters[i], cutLine[i]);
				System.out.println(parsed);
				if(constParameters[i].getSimpleName().equalsIgnoreCase("List")){
					parameters.add(parsed);
				}else{
					parameters.add(parsed.get(0));
				}
			}
			return constructor.newInstance(parameters.toArray());
		}
		return null;
		
	}
	
	@SuppressWarnings("unchecked")
	private static List getObjectFromSCV(Class clazz, String value) throws ParseException{
		List entity = new ArrayList();
		
		if(value != null){
			switch(clazz.getSimpleName()){
			case "Integer":
				entity.add(new Integer(Integer.parseInt(value)));
				break;
			case "String":
				entity.add(value);
				break;
			case "Double":
				entity.add(new Double(Double.parseDouble(value)));
				break;
			case "Boolean":
				entity.add(new Boolean(Boolean.parseBoolean(value)));
				break;
			case "Date":
				DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
				entity.add(df.parse(value));
				break;
			
			}
		}
		return entity;
		
	}
	
	

}
