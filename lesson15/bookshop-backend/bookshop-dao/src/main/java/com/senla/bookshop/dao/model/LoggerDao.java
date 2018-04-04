package com.senla.bookshop.dao.model;

import org.springframework.stereotype.Repository;

import com.senla.bookshop.api.dao.ILoggerDao;

@Repository
public class LoggerDao extends AbstractDao<LoggerDao> implements ILoggerDao {

	public LoggerDao() {
		super(LoggerDao.class);
	}

}
