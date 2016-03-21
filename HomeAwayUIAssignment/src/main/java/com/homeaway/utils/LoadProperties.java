package com.homeaway.utils;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class LoadProperties {
	public static Configuration config = new Configuration();
	static Properties properties = new Properties();
	final static Logger logger = Logger.getLogger(LoadProperties.class);
	static {
		setConfiguration();
	}

	private static void setConfiguration() {
		properties =PropertyUtils.readConfigFile(Constants.CONFIG_FILE_PATH);
		config.setTimeOut(Integer.parseInt(properties.getProperty("timeout")));
		config.setDriver(getWebDriver(properties.getProperty("browser")));
		config.setBaseURL(properties.getProperty("baseurl"));
	}

	public static Configuration getConfiguration() {
		return config;
	}

	private static WebDriver getWebDriver(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			logger.debug("selecting firefox driver for operation");
			return new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(Constants.ChromeDriver,Constants.ChromeDriverLocation);
			logger.debug("selecting chrome driver for operation");
			return new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty(Constants.IEDriver,Constants.IEDriverLocation);
			logger.debug("selecting ie driver for operation");
			return new InternetExplorerDriver();
		}
		return null;
	}
}
