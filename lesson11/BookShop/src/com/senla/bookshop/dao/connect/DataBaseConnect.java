package com.senla.bookshop.dao.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.senla.bookshop.dao.utils.PropertyHolder;

public class DataBaseConnect {
	
	private static final Logger logger = LogManager.getLogger(DataBaseConnect.class);
	
	private static DataBaseConnect instance;
	
	private static String DRIVER = PropertyHolder.getInstance().getDbDriver();
	private static String HOST = PropertyHolder.getInstance().getDbHost();
	private static String PASSWORD = PropertyHolder.getInstance().getDbPassword();
	private static String LOGIN = PropertyHolder.getInstance().getDbLogin() ;
	
	private Connection connection;
	
	private DataBaseConnect(){}
	
	public static DataBaseConnect getInstance() {
		if (instance == null) {
			instance = new DataBaseConnect();
		}

		return instance;
	}
	
	public Connection getConnection() {
		if (connection == null) {
			Connect();
		}

		return connection;
	}
	
	public void Connect(){
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(HOST, LOGIN, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			logger.error("SQLexception" + e);
		}
	}
	
	public void closeConnect(){
		try {
			if (connection != null) {
				connection.close();
				logger.info("Connection closed");
			}
		} catch (SQLException e) {
			logger.error("Connection is not closed", e);
		}
	}
	
	
}
