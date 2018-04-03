package com.senla.bookshop.dao.model;

import org.springframework.stereotype.Repository;

import com.senla.bookshop.api.dao.ILoggerDAO;

@Repository
public class LoggerDao extends AbstractDao<LoggerDao> implements ILoggerDAO {

	public LoggerDao() {
		super(LoggerDao.class);
	}

}
