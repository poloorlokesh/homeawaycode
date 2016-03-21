package com.homeaway.utils;

import org.openqa.selenium.WebDriver;

public class Configuration {
	private WebDriver driver;
	private int timeOut;
	private String baseURL;
	public int getTimeOut() {
		return timeOut;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	public String getBaseURL() {
		return baseURL;
	}
	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}
	
}