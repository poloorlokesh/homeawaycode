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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.homeaway.utils.Constants;
import com.homeaway.utils.LoadProperties;

/**
 * All WebElements are identified by @FindBy annotation in checkout page
 * 
 * @author Lokesh,Poloor Mahesh
 */
public class CheckoutPage {

	WebDriver driver;
	final static Logger logger = Logger.getLogger(LoadProperties.class);

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(LoadProperties.getConfiguration().getTimeOut(),
				TimeUnit.SECONDS);
	}

	@FindBy(xpath = Constants.shippingCountryList)
	WebElement shippingCountryList;

	@FindBy(xpath = Constants.purchaseButton)
	WebElement purchaseButton;

	@FindBy(xpath = Constants.emailIdText)
	WebElement emailIdText;

	public String getEmailIdText() {
		return emailIdText.getAttribute("value");
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

	@FindBy(xpath = Constants.cartCountLabel)
	WebElement cartCountLabel;

	@FindBy(xpath = Constants.removeItemButton)
	WebElement removeItemButton;

	public String clickPurchaseButton() {
		if (getEmailIdText().isEmpty()) {
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.loginAndReturnCheckoutPage();
			checkoutFields();
		}
		logger.debug("Proceeding with purchase");
		new Select(shippingCountryList).selectByValue(Constants.shippingCountryValue);
		purchaseButton.click();
		return driver.getPageSource();
	}

	public void waitForPage() {
		WebDriverWait wait = new WebDriverWait(driver, LoadProperties.getConfiguration().getTimeOut());
		wait.until(ExpectedConditions.elementToBeClickable(purchaseButton));
	}

	public String removeCartItem() {
		logger.debug("Removing Items from Cart");
		if (removeItemButton.isEnabled()) {
			removeItemButton.click();
		}
		return cartCountLabel.getText();
	}

	public void checkoutFields() {
		if (getAddress().isEmpty()) {
			address.sendKeys(Constants.addressValue);
		}

		if (getCity().isEmpty()) {
			city.sendKeys(Constants.cityValue);
		}

		if (getLastName().isEmpty()) {
			lastName.sendKeys(Constants.lastNameValue);
		}

	}
}
