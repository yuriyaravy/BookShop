package com.senla.bookshop.di;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;


public class DependencyIngection {
	
	private final static Logger logger = Logger.getLogger(DependencyIngection.class);
	
	private static DependencyIngection dependencyIngection;
	
	private static Map<String, Object> classList = new HashMap<String, Object>();
	
	private DependencyIngection(){
	}
	
	public static DependencyIngection getInctance(){
		if(dependencyIngection == null){
			dependencyIngection = new DependencyIngection();
		}
		return dependencyIngection;
	}
	
	public Object getClassInstance(Class<?> entClazz){
		Object obj = null;
		if (classList.containsKey(entClazz.getName())) {
			obj = classList.get(entClazz.getName());
		} else {
			String implClassName = ReadDependency.getClassName(entClazz.getName());
			try {
				Class<?> implClass = Class.forName(implClassName);
				obj = implClass.newInstance();
				classList.put(entClazz.getName(), obj);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		}
		return obj;
	}		

}
