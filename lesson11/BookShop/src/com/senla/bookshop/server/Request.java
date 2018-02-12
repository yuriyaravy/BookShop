package com.senla.bookshop.server;

import java.io.Serializable;

public class Request implements Serializable{
	
	private String methodName;
	private Object[] parameters;
	
	public Request(String methodName, Object[] parameters){
		this.methodName = methodName;
		this.parameters = parameters;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Object[] getParameters() {
		return parameters;
	}

	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}

	

}
