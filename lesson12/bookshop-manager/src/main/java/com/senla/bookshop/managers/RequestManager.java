package com.senla.bookshop.managers;


import java.util.List;

import com.mysql.jdbc.Connection;
import com.senla.bookshop.api.controllers.IRequestManager;
import com.senla.bookshop.api.dao.IRequestDao;
import com.senla.bookshop.dao.connect.DataBaseConnect;
import com.senla.bookshop.di.DependencyIngection;
import com.senla.bookshop.entiti.Request;
import com.senla.bookshop.utils.annotations.AnnotationCSVReader;
import com.senla.bookshop.utils.annotations.AnnotationCSVWriter;

public class RequestManager implements IRequestManager{
	
	private final IRequestDao requestDao = (IRequestDao) DependencyIngection.getInctance().getClassInstance(IRequestDao.class);
	private DataBaseConnect dbconnect = DataBaseConnect.getInstance();
	
	@Override
	public void getAnnotationRequest() throws Exception{
		requestDao.update((Connection) dbconnect.getConnection(),(Request) AnnotationCSVReader.readerFromCsv(Request.class));
	}
	@Override
	public void saveAnnotationRequest() throws Exception{
		List<Request> list = requestDao.getRequest((Connection) dbconnect.getConnection());
		AnnotationCSVWriter.wtiteToCSVFile(list);
	}
	
	@Override
	public void addRequest(Object t) throws Exception{
		requestDao.create((Connection) dbconnect.getConnection(),(Request)t);
	}
	
	@Override
	public List<String> getAllBookRequestByName() throws Exception{
		return requestDao.getAllBookRequestByName((Connection) dbconnect.getConnection());
	}
	
	@Override
	public List<Double> getAllBookRequestByAmount() throws Exception{
		return requestDao.getAllBookRequestByAmount((Connection) dbconnect.getConnection());
	}
	@Override
	public List<Request> getRequest() throws Exception{
		return requestDao.getRequest((Connection) dbconnect.getConnection());
	}

}
