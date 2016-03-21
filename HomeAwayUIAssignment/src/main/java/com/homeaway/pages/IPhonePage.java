/**
 * 
 */
package com.homeaway.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.homeaway.utils.Constants;
import com.homeaway.utils.LoadProperties;

/**
 * All WebElements are identified by @FindBy annotation in IPhone page
 * 
 * @author Lokesh, Poloor Mahesh
 */
public class IPhonePage {

	WebDriver driver;
	final static Logger logger = Logger.getLogger(IPhonePage.class);

	public IPhonePage(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(LoadProperties.getConfiguration().getTimeOut(),
				TimeUnit.SECONDS);
	}

	@FindBy(xpath = Constants.itemLink)
	WebElement iPhoneLink;

	public ItemDescriptionPage clickItem() {
		logger.debug("Clicking Iphone 16 GB description page");
		iPhoneLink.click();
		return PageFactory.initElements(driver, ItemDescriptionPage.class);
	}

	public void waitForPage() {
		WebDriverWait wait = new WebDriverWait(driver, LoadProperties.getConfiguration().getTimeOut());
		wait.until(ExpectedConditions.elementToBeClickable(iPhoneLink));
	}

}
