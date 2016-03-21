/**
 * 
 */
package com.homeaway.pages;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.homeaway.utils.Constants;
import com.homeaway.utils.LoadProperties;

/**
 * All WebElements are identified by @FindBy annotation in checkout page
 * 
 * @author Lokesh,Poloor Mahesh
 *
 */
public class LoginPage {

	WebDriver driver;
	final static Logger logger = Logger.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(LoadProperties.getConfiguration().getTimeOut(),
				TimeUnit.SECONDS);
	}

	@FindBy(xpath = Constants.userNameText)
	WebElement userName;

	@FindBy(xpath = Constants.passwordText)
	WebElement password;

	@FindBy(xpath = Constants.loginButton)
	WebElement loginButton;
	
	@FindBy(xpath = Constants.logOutLink)
	WebElement loginOutput;

	public CheckoutPage loginAndReturnCheckoutPage() {
		login();
		return PageFactory.initElements(driver, CheckoutPage.class);
	}
	
	public MyAccountPage loginAndReturnMyAccountPage()
	{
		logger.debug("Login only if it is already not logged in");
		if(driver.findElements(By.xpath(Constants.logOutLink)).size()==0){
		login();
		}
		return PageFactory.initElements(driver, MyAccountPage.class);
	}
	
	
	private  void login()
	{
		logger.debug("Loggging in ");
		userName.clear();
		userName.sendKeys(Constants.userName);
		password.clear();
		password.sendKeys(Constants.password);
		loginButton.click();
		WebDriverWait wait = new WebDriverWait(driver, LoadProperties.getConfiguration().getTimeOut());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.logOutLink)));
		
	}

}
