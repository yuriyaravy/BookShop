package com.senla.bookshop.server;

import java.io.Serializable;

public class Response implements Serializable{
	
	private Object object;
	
	public Response(Object object){
		this.object = object;
	}
	
	public Object getObject() {
		return object;
	}

}
