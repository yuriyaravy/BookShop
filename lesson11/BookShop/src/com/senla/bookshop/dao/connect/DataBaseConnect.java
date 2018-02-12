package com.senla.bookshop.dao.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.senla.bookshop.dao.utils.PropertyHolder;

public class DataBaseConnect {
	
	private static final Logger logger = LogManager.getLogger(DataBaseConnect.class);
	
	private static DataBaseConnect dataBaseConnect;
	
	private String DRIVER = PropertyHolder.getInstance().getDbDriver();
	private String HOST = PropertyHolder.getInstance().getDbHost();
	private String PASSWORD = PropertyHolder.getInstance().getDbPassword();
	private String LOGIN = PropertyHolder.getInstance().getDbLogin() ;
	
	private Connection mysqlConnect;
	
	private DataBaseConnect(){}
	
	public static DataBaseConnect getInstance() {
		if (dataBaseConnect == null) {
			dataBaseConnect = new DataBaseConnect();
			PropertyHolder.getInstance().init();
		}

		return dataBaseConnect;
	}
	
	public void Connect(){
		try {
			Class.forName(DRIVER);
			mysqlConnect = DriverManager.getConnection(HOST, LOGIN, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(e);
		}
	}
	
	public void closeConnect(){
		try {
			if (mysqlConnect != null) {
				mysqlConnect.close();
				logger.info("Connection closed");
			}
		} catch (SQLException e) {
			logger.error("Connection is not closed", e);
		}
	}

	public Connection getMysqlConnect() {
		return mysqlConnect;
	}

	
}
