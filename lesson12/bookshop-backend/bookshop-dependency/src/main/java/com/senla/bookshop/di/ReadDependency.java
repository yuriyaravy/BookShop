package com.senla.bookshop.di;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadDependency {
	
	private final static Logger logger = Logger.getLogger(DependencyIngection.class);
	
	private static final String DEPENDENCY_PATH = "src/main/resources/dependency.property";
	
	public static Map<Object, Object> dependencies;
	
	public static void getDependencyFromFile(){
		dependencies = new Properties();
		try (FileInputStream  input = new FileInputStream(DEPENDENCY_PATH)){
			((Properties)dependencies).load(input);
		}catch (IOException  e) {
			logger.error(e.getMessage());
		}
	}
	
	public static String getClassName(String key) {
		if (dependencies == null) {
			getDependencyFromFile();
		}
		return (String) dependencies.get(key);
	}

}
