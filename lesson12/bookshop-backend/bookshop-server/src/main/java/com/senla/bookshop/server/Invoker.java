package com.senla.bookshop.server;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.facade.Facade;

public class Invoker {
	
	private static final Logger logger = Logger.getLogger(Invoker.class);
	
	public static Object execute(String methodName, Object parameters){
		Facade facadeManager = (Facade) DependencyIngection.getInctance().getClassInstance(Facade.class);
		Object response = null;
		try {
			if(parameters != null) {	
				response = facadeManager.getClass().getMethod(methodName, Object.class).invoke(facadeManager, parameters);
			} else {
				response = facadeManager.getClass().getMethod(methodName, new Class[] {}).invoke(facadeManager);
			}
		} catch (NoSuchMethodException e) {
			logger.error("No such Method!", e);
		} catch (IllegalAccessException e) {
			logger.error("Illegal Access!", e);
		} catch (InvocationTargetException e) {
			logger.error("Invocation Target!", e);
		}
		return response;
	}
}
