package com.senla.bookshop.di;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.senla.bookshop.annotations.DiStorage;

public class DependencyIngection {
	
	private static DependencyIngection dependencyIngection;
	
	private static final String DEPENDENCY_PATH = "data/dependency.property";
	
	private Map<String, String> dependencies = new HashMap<>();
	
	private DependencyIngection(){
	}
	
	public static DependencyIngection getInctance(){
		if(dependencyIngection == null){
			dependencyIngection = new DependencyIngection();
		}
		return dependencyIngection;
	}
	
	public String getDependencyFromFile(){
		String path = null;
		Properties properties = new Properties();
		try (FileInputStream in = new FileInputStream(DEPENDENCY_PATH)){
		properties.load(in);
		dependencies = (Map<String, String>) properties.clone();
		System.out.println(dependencies);
		}catch (IOException  e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public Object getStorageInstance(Class<?> entClazz){
		Class<?> clazz = null;
		boolean isSingelton = false;
			try {
				clazz = Class.forName(dependencies.get(entClazz.getName()));
				
					if(clazz.isAnnotationPresent(DiStorage.class))
							isSingelton= true;
						if(isSingelton){
							return clazz.getMethod("getInstance").invoke(null);
						}else{
							return clazz.newInstance();
							}
					
						
							} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException
									| SecurityException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
								e.printStackTrace();
								return null;
							}				
	}

}
