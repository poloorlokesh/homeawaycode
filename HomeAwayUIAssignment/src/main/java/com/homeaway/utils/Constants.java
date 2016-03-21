package com.homeaway.utils;

public class Constants {

    //Config Path
    public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/config/config.properties";
   
    // Driver locations 
    public static final String ChromeDriverLocation="drivers/chromedriver.exe";
    public static final String IEDriverLocation="drivers/IEDriverServer.exe";
    public static final String IEDriver="webdriver.ie.driver";
    public static final String ChromeDriver="webdriver.chrome.driver";
    
    //Home Page 
    public static final String productCategory = "//a[contains(text(),'Product Category')]";
    public static final String iPhone="//a[contains(text(),'iPhones')]";
    public static final String myAccoutLink="//*[@id='account']/a";
    public static final String logOutText="Log out";
    
    //IPhone Page
    public static final String itemLink="//a[contains(text(),'Apple iPhone 4S 16GB SIM-Free – Black')]";
    //public static final String itemLink="//*[@id='default_products_page_container']/div[5]/div[2]/h2/a";
    
    //IPhone Description Page
    public static final String addToCartButton="//input[@value='Add To Cart']";
    public static final String checkoutButton="Go to Checkout";
    public static final String continueButton="//span[contains(text(),'Continue')]";
    
    //Login Details 
    public static final String userName="homeawayuser";
    public static final String password="homeaway@12";
    
    //MyAccount Page 
    public static final String countryValue="US";
    public static final String cityValue="Austin";
    public static final String firstNameValue="HomeAway";
    public static final String lastNameValue="Expedia";
    public static final String phoneValue="4004004000";
    public static final String addressValue="Austin,Texas";
    public static final String emailValue="homeaway@homeaway.com";
    public static final String postalCodeValue="73344";
    public static final String logOutLink="//*[@id='account_logout']/a";
    
    //Login Page
    public static final String userNameText="//*[@id='log']";
    public static final String passwordText="//*[@id='pwd']";
    public static final String loginButton="//*[@id='login']";
    
    //Checkout Page
    public static final String shippingCountryValue="US";
    public static final String shippingCountryList="//*[@id='current_country']";
    public static final String purchaseButton="//*[@id='wpsc_shopping_cart_container']/form/div[4]/div/div/span/input";
    public static final String cartCountLabel="//*[@id='header_cart']/a/em[1]";
    public static final String cartCountValue="0";
    public static final String removeItemButton="//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[6]/form/input[4]";
    
    //MyAccount Page 
    public static final String emailIdText="//*[@id='wpsc_checkout_form_9']";
    public static final String firstNameText="//*[@id='wpsc_checkout_form_2']";
    public static final String lastNameText="//*[@id='wpsc_checkout_form_3']";
    public static final String cityText="//*[@id='wpsc_checkout_form_5']";
    public static final String addressText="//*[@id='wpsc_checkout_form_4']";
    public static final String phoneText="//*[@id='wpsc_checkout_form_18']";
    public static final String countryList="//*[@id='wpsc_checkout_form_7']";
    public static final String billingAddressSame="shippingSameBilling";
    public static final String postalCodeText="//*[@id='wpsc_checkout_form_8']";
    public static final String submitProfile="submit";
    public static final String yourDetailsLink="Your Details";
    
    //Verification Text Constants
    public static final String shippingAmount="Total Shipping: $12.00";
    public static final String totalValue="Total: $282.00";
    public static final String successMessage="Thank you for purchasing with ONLINE STORE, any items to be shipped will be processed as soon as possible, any items that can be downloaded can be downloaded using the links on this page. All prices include tax and postage and packaging where applicable.";
    
    
}
