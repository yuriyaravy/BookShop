package com.senla.bookshop.managers;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.senla.bookshop.api.controllers.IRequestManager;
import com.senla.bookshop.dao.api.IRequestDao;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;

public class RequestManager implements IRequestManager{
	
	private final IRequestDao requestDao = (IRequestDao) DependencyIngection.getInctance().getClassInstance(IRequestDao.class);
	
	@Override
	public void getAnnotationRequest() throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ParseException, SQLException{
		requestDao.create((Request) AnnotationCSVReader.readerFromCsv(Request.class));
	}
	
	@Override
	public void addRequest(Object t) throws SQLException{
		requestDao.create((Request)t);
	}
	
	@Override
	public List<String> getAllBookRequestByName(){
		return requestDao.getAllBookRequestByName();
	}
	
	@Override
	public List<Double> getAllBookRequestByAmount(){
		return requestDao.getAllBookRequestByAmount();
	}
	@Override
	public List<Request> getRequest(){
		return requestDao.getRequest();
	}

}
