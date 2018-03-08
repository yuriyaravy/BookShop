package com.senla.bookshop.server;

import java.io.Serializable;

public class Response implements Serializable{
	
	private static final long serialVersionUID = 7761827563522952769L;

	private Object[] object;
	
	private Boolean ok;
	
	public Response(Object[] object) {
		if (object == null) {
			ok = false;
		} else {
			ok = true;
			this.object = object;
		}
	}

	public Boolean isOk() {
		return ok;
	}
	public Object getObject() {
		return object;
	}

}
