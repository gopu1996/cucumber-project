package com.org.utlity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReader {

	private static String configfile = "config.properties";

	public static Properties loadProperties() {
		
		FileInputStream file = null;
		Properties property = new Properties();
		try {
			file = new FileInputStream(configfile);
			property.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return property;

	}


	public static String getCromeDriver() {

		String Driver = loadProperties().getProperty("cromeDriver");
		if (Driver != null) {
			return Driver;
		} else {
			throw new RuntimeException("Driver not Found");
		}
	}
	
	public static String getFireFoxDriver() {

		String Driver = loadProperties().getProperty("FireFoxDriver");
		if (Driver != null) {
			return Driver;
		} else {
			throw new RuntimeException("Driver not Found");
		}
	}
	
	public static String getIEDriver() {

		String Driver = loadProperties().getProperty("IEDriver");
		if (Driver != null) {
			return Driver;
		} else {
			throw new RuntimeException("Driver not Found");
		}
	}
	
	public static String getEdgeDriver() {

		String Driver = loadProperties().getProperty("edgeDriver");
		if (Driver != null) {
			return Driver;
		} else {
			throw new RuntimeException("Driver not Found");
		}
	}
	


	public static String userName() {

		String userName = loadProperties().getProperty("username");
		if (userName != null) {
			return userName;
		} else {
			throw new RuntimeException("userName not Found");
		}

	}

	public static String password() {

		String password = loadProperties().getProperty("password");
		if (password != null) {
			return password;
		} else {
			throw new RuntimeException("password not Found");
		}

	}

	public static String getQaUrl() {
		String url = loadProperties().getProperty("qa_url");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("url not found");
		}
	}
	
	public static String getDevUrl() {
		String url = loadProperties().getProperty("dev_url");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("url not found");
		}
	}
	
	public static String getEnv() {
		String env = loadProperties().getProperty("env");
		if (env != null) {
			return env;
		} else {
			throw new RuntimeException("env not found");
		}
	}

	public static long getWait() {
		String wait = loadProperties().getProperty("wait");
		if (wait != null) {
			return Long.parseLong(wait);
		} else {
			throw new RuntimeException("url not found");
		}
	}

	public static String browser() {
		String browser = loadProperties().getProperty("browser");
		if (browser != null) {
			return browser;
		} else {
			throw new RuntimeException("Browser not found");
		}
	}
}
