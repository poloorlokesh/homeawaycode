package com.homeaway.apiutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;


public class UrlUtils {
	
	final static Logger logger = Logger.getLogger(UrlUtils.class);
	public static String nearestURL=null;
	public static String stationIdURL=null;
	public static String apiKey=null;
	
	static 
	{
		getConfiguration();
		
	}
	
	private static void getConfiguration()
	{
	 Properties properties = new Properties();
	 properties = readConfigFile(Constants.CONFIG_FILE_PATH);
	 nearestURL = (String) properties.get("nearesturl");
	 stationIdURL= (String) properties.get("stationidurl");
	 apiKey= (String) properties.get("apikey");
	 
	}
	
	public static String getNearestStationURL(String location)
	{
		StringBuffer url=new StringBuffer();
		url.append(nearestURL).append(apiKey).append("&location=").append(location);
		return url.toString();
	}
	
	public static String getStationIdURL(String stationId)
	{
		StringBuffer url=new StringBuffer();
		url.append(stationIdURL).append(stationId).append(".json?api_key=").append(apiKey);
		return url.toString();
		
	}
	
	public static Properties readConfigFile(String file) {
		InputStream input = null;
		Properties properties = new Properties();
		try {
			input = new FileInputStream(file);
			properties.load(input);
		} catch (IOException ex) {
			logger.error("Error occured while reading property file" + ex.getMessage());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error("Error occured while reading property file" + e.getMessage());
				}
			}
		}
		return properties;
	}

}
