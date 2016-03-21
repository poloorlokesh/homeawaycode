/**
 * 
 */
package com.homeaway.pages;

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
 * All WebElements are identified by @FindBy annotation in IPhone description
 * page
 * @author Lokesh,Poloor Mahesh
 */
public class ItemDescriptionPage {

	WebDriver driver;
	WebDriverWait wait;

	final static Logger logger = Logger.getLogger(LoadProperties.class);
	public ItemDescriptionPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, LoadProperties.getConfiguration().getTimeOut());
	}

	@FindBy(xpath = Constants.addToCartButton)
	WebElement addToCartButton;

	@FindBy(partialLinkText = Constants.checkoutButton)
	WebElement checkoutButton;

	@FindBy(xpath = Constants.continueButton)
	WebElement continueButton;

	public CheckoutPage clickAddToCartAndContinue() {
		logger.debug("Clicking Add to Cart and click Continue");
		addToCartButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(Constants.checkoutButton)));
		checkoutButton.click();
		continueButton.click();
		return PageFactory.initElements(driver, CheckoutPage.class);
	}

	public CheckoutPage clickAddToCart() {
		logger.debug("Clicking Add to Cart");
		addToCartButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(Constants.checkoutButton)));
		checkoutButton.click();
		return PageFactory.initElements(driver, CheckoutPage.class);
	}

}
