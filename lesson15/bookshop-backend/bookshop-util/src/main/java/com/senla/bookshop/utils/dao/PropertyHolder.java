package com.senla.bookshop.utils.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PropertyHolder {

	private static final String PROPERTIES_PATH = "src/dataBase.properties";
	private static Logger logger = LogManager.getLogger(PropertyHolder.class);

	private static PropertyHolder instance;

	private String dbDriver;
	private String dbHost;
	private String dbLogin;
	private String dbPassword;

	private PropertyHolder() {
	}

	public static PropertyHolder getInstance() {
		if (instance == null) {
			instance = new PropertyHolder();
			instance.init();
		}
		return instance;
	}

	public void init() {
		Properties prop = readFile();
		dbDriver = prop.getProperty("dbDriver");
		dbHost = prop.getProperty("dbHost");
		dbLogin = prop.getProperty("dbLogin");
		dbPassword = prop.getProperty("dbPassword");
	}

	public Properties readFile() {
		Properties prop = new Properties();
		try (InputStream input = new FileInputStream(PROPERTIES_PATH)) {
			prop.load(input);
			return prop;
		} catch (IOException e) {
			logger.error(e);
			return null;
		}

	}

	public String getDbDriver() {
		return dbDriver;
	}

	public String getDbHost() {
		return dbHost;
	}

	public String getDbLogin() {
		return dbLogin;
	}

	public String getDbPassword() {
		return dbPassword;
	}

}
