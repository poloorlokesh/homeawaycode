/**
 * 
 */
package com.homeaway.utils;

import org.openqa.selenium.WebDriver;

/**
 * Factory class for starting the browser
 * @author Lokesh, Poloor Mahesh
 *
 */
public class BrowserFactory {
	
	public static WebDriver startBrowser()
	{
		WebDriver driver=null;
		Configuration config = LoadProperties.getConfiguration();
		driver= config.getDriver();
		driver.manage().window().maximize();
		driver.get(config.getBaseURL());
		return driver;
	}

}
