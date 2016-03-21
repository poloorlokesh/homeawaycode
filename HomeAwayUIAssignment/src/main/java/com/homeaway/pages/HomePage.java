/**
 * 
 */
package com.homeaway.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.homeaway.utils.Constants;
import com.homeaway.utils.LoadProperties;

/**
 * All WebElements are identified by @FindBy annotation in home page store demo
 * QA
 * @author Lokesh, Poloor Mahesh
 */
public class HomePage {

	WebDriver driver;
	final static Logger logger = Logger.getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = Constants.productCategory)
	WebElement productCategory;

	@FindBy(xpath = Constants.iPhone)
	WebElement iPhone;

	@FindBy(xpath = Constants.myAccoutLink)
	WebElement myAccountLink;

	@FindBy(partialLinkText = Constants.logOutLink)
	WebElement logOutLink;

	public IPhonePage clickOverIphone() {
		logger.debug("Entered into clickoverIphone");
		Actions actions = new Actions(driver);
		actions.moveToElement(productCategory).perform();
		actions.moveToElement(iPhone).click().perform();
		logger.debug("Exisiting into clickoverIphone");
		return PageFactory.initElements(driver, IPhonePage.class);
	}

	public LoginPage clickMyAccount() {
		logger.debug("Go into MyAccount Page");
		myAccountLink.click();
		return PageFactory.initElements(driver, LoginPage.class);

	}

	public void waitForPage() {
		WebDriverWait wait = new WebDriverWait(driver, LoadProperties.getConfiguration().getTimeOut());
		wait.until(ExpectedConditions.textToBePresentInElement(logOutLink, Constants.logOutLink));
	}
}
