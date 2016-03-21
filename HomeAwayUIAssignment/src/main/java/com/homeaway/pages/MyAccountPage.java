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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.homeaway.utils.Constants;
import com.homeaway.utils.LoadProperties;

/**
 * All WebElements are identified by @FindBy annotation in checkout page
 * 
 * @author Lokesh,Poloor Mahesh
 */
public class MyAccountPage {

	WebDriver driver;
	final static Logger logger = Logger.getLogger(MyAccountPage.class);

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(LoadProperties.getConfiguration().getTimeOut(),
				TimeUnit.SECONDS);
	}

	@FindBy(xpath = Constants.firstNameText)
	WebElement firstName;

	public String getFirstName() {
		return firstName.getAttribute("value");
	}

	@FindBy(xpath = Constants.lastNameText)
	WebElement lastName;

	public String getLastName() {
		return lastName.getAttribute("value");
	}

	@FindBy(xpath = Constants.addressText)
	WebElement address;

	public String getAddress() {
		return address.getAttribute("value");
	}

	@FindBy(xpath = Constants.cityText)
	WebElement city;

	public String getCity() {
		return city.getAttribute("value");
	}

	@FindBy(xpath = Constants.phoneText)
	WebElement phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber.getAttribute("value");
	}

	@FindBy(xpath = Constants.emailIdText)
	WebElement emailId;

	@FindBy(xpath = Constants.countryList)
	WebElement countryList;

	public String getCountryCode() {
		return new Select(countryList).getFirstSelectedOption().getAttribute("value");
	}

	@FindBy(xpath = Constants.postalCodeText)
	WebElement postalCode;

	public String getPostalCode() {
		return postalCode.getAttribute("value");
	}

	@FindBy(id = Constants.billingAddressSame)
	WebElement billingAddressSelector;

	@FindBy(name = Constants.submitProfile)
	WebElement saveProfile;

	@FindBy(partialLinkText = Constants.yourDetailsLink)
	WebElement yourDetails;

	@FindBy(xpath = Constants.logOutLink)
	WebElement logOut;

	public MyAccountPage clickMyDetails() {
		yourDetails.click();
		waitForPage(By.xpath(Constants.logOutLink));
		return PageFactory.initElements(driver, MyAccountPage.class);
	}

	public MyAccountPage updateProfileDetails() {

		logger.debug("Entering user details to update");
		yourDetails.click();
		firstName.clear();
		firstName.sendKeys(Constants.firstNameValue);
		lastName.clear();
		lastName.sendKeys(Constants.lastNameValue);
		address.clear();
		address.sendKeys(Constants.addressValue);
		city.clear();
		city.sendKeys(Constants.cityValue);
		new Select(countryList).selectByValue(Constants.countryValue);
		postalCode.clear();
		postalCode.sendKeys(Constants.postalCodeValue);
		phoneNumber.clear();
		phoneNumber.sendKeys(Constants.phoneValue);
		if (!billingAddressSelector.isSelected()) {
			billingAddressSelector.click();
		}
		saveProfile.click();
		waitForPage(By.xpath(Constants.lastNameText));
		waitForPage(By.xpath(Constants.logOutLink));
		waitForPage(By.xpath(Constants.addressText));
		return PageFactory.initElements(driver, MyAccountPage.class);

	}

	public LoginPage clickLogOut() {
		logOut.click();
		waitForPage(By.xpath(Constants.loginButton));
		return PageFactory.initElements(driver, LoginPage.class);
	}

	public void waitForPage(By object) {
		WebDriverWait wait = new WebDriverWait(driver, LoadProperties.getConfiguration().getTimeOut());
		wait.until(ExpectedConditions.elementToBeClickable(object));
	}
}
