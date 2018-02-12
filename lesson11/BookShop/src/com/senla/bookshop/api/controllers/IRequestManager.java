package com.senla.bookshop.api.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

import com.senla.bookshop.entities.Request;

public interface IRequestManager {
	
	void getAnnotationRequest() throws FileNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException, ParseException, SQLException;

	List<String> getAllBookRequestByName();

	void addRequest(Object t) throws SQLException;

	List<Double> getAllBookRequestByAmount();

	List<Request> getRequest();
	

}
