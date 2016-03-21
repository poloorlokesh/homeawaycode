package com.homeaway.uitests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.homeaway.pages.CheckoutPage;
import com.homeaway.pages.HomePage;
import com.homeaway.pages.IPhonePage;
import com.homeaway.pages.ItemDescriptionPage;
import com.homeaway.pages.LoginPage;
import com.homeaway.pages.MyAccountPage;
import com.homeaway.utils.BrowserFactory;
import com.homeaway.utils.Constants;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeAwayUITest {
	
	WebDriver driver =null;
	
	@BeforeClass
	public void beforeClass()
	{
		driver = BrowserFactory.startBrowser();
	}
	
	@Test(priority=1)
	public void verifyEmptyCartTest()
	{
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		Assert.assertNotNull(homePage,"Problem loading the Home page");
		IPhonePage iphonePage = homePage.clickOverIphone();
		Assert.assertNotNull(iphonePage,"Problem loading the IPhone page");
		ItemDescriptionPage ipage = iphonePage.clickItem();
		Assert.assertNotNull(iphonePage,"Problem loading the Item description page");
		CheckoutPage checkOutPage = ipage.clickAddToCart();
		Assert.assertNotNull(iphonePage,"Problem loading the Checkout page");
		String cartItemCount =checkOutPage.removeCartItem();
		Assert.assertEquals(cartItemCount, Constants.cartCountValue);
	}
	
	@Test(priority=2)
	public void orderIPhoneTest() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		Assert.assertNotNull(homePage,"Problem loading the Home page");
		IPhonePage iphonePage = homePage.clickOverIphone();
		Assert.assertNotNull(iphonePage,"Problem loading the IPhone page");
		ItemDescriptionPage ipage = iphonePage.clickItem();
		Assert.assertNotNull(iphonePage,"Problem loading the Item description page");
		CheckoutPage checkOutPage = ipage.clickAddToCartAndContinue();
		Assert.assertNotNull(iphonePage,"Problem loading the Checkout page");
		String pageResult = checkOutPage.clickPurchaseButton();
		Assert.assertEquals(true, pageResult.contains(Constants.successMessage), "Failed didn't get the Success Page");
		Assert.assertEquals(true, pageResult.contains(Constants.shippingAmount),
				"Failed didn't get the Shipping amount properly");
		Assert.assertEquals(true, pageResult.contains(Constants.totalValue),
				"Failed didn't get the total amount properly");
		
	}
	
	@Test(priority=3)
	public void updateProfileDetailsTest()
	{
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		Assert.assertNotNull(homePage,"Problem loading the Home page");
		LoginPage loginPage = homePage.clickMyAccount();
		Assert.assertNotNull(homePage,"Problem loading the Login page");
		MyAccountPage myAccountPage = loginPage.loginAndReturnMyAccountPage();
		Assert.assertNotNull(homePage,"Problem loading the My Account page");
		myAccountPage = myAccountPage.updateProfileDetails();
		loginPage = myAccountPage.clickLogOut();
	    myAccountPage = loginPage.loginAndReturnMyAccountPage();
	    myAccountPage = myAccountPage.clickMyDetails();
	    SoftAssert softAssert = new SoftAssert();
	    softAssert.assertEquals(myAccountPage.getFirstName(), Constants.firstNameValue,"First Name didn't match, Expected  - "+Constants.firstNameValue + " but found "+myAccountPage.getFirstName());
	    softAssert.assertEquals(myAccountPage.getPhoneNumber(), Constants.phoneValue,"Phone didn't match, Expected - "+Constants.phoneValue + " but found "+myAccountPage.getPhoneNumber());
	    softAssert.assertEquals(myAccountPage.getCountryCode(), Constants.countryValue,"Country code didn't match, Expected - "+Constants.countryValue + " but found "+myAccountPage.getCountryCode());
	    softAssert.assertEquals(myAccountPage.getLastName(), Constants.lastNameValue,"Last Name didn't match, Expected - "+Constants.lastNameValue + " but found "+myAccountPage.getLastName());
	    softAssert.assertEquals(myAccountPage.getAddress(), Constants.addressValue,"Address didn't match, Expected - "+Constants.addressValue + " but found "+myAccountPage.getAddress());
	    softAssert.assertEquals(myAccountPage.getCity(), Constants.cityValue,"City didn't match, Expected - "+Constants.cityValue + " but found "+myAccountPage.getCity());
	    softAssert.assertAll();
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.close();;
	}
	
}