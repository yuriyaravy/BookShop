package com.senla.bookshop.managers;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.senla.bookshop.api.controllers.IRequestManager;
import com.senla.bookshop.dao.api.IRequestDao;
import com.senla.bookshop.dao.connect.DataBaseConnect;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;

public class RequestManager implements IRequestManager{
	
	private final IRequestDao requestDao = (IRequestDao) DependencyIngection.getInctance().getClassInstance(IRequestDao.class);
	private DataBaseConnect dbconnect = DataBaseConnect.getInstance();
	
	@Override
	public void getAnnotationRequest() throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ParseException, SQLException{
		requestDao.create((Connection) dbconnect.getConnection(),(Request) AnnotationCSVReader.readerFromCsv(Request.class));
	}
	
	@Override
	public void addRequest(Object t) throws SQLException{
		requestDao.create((Connection) dbconnect.getConnection(),(Request)t);
	}
	
	@Override
	public List<String> getAllBookRequestByName(){
		return requestDao.getAllBookRequestByName((Connection) dbconnect.getConnection());
	}
	
	@Override
	public List<Double> getAllBookRequestByAmount(){
		return requestDao.getAllBookRequestByAmount((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Request> getRequest(){
		return requestDao.getRequest((Connection) dbconnect.getConnection());
	}

}
