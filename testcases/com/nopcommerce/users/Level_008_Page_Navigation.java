package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.UserHomePageObject;
import pageObjects.nopcommerce.UserLoginPageObject;
import pageObjects.nopcommerce.UserOrdersPageObject;
import pageObjects.nopcommerce.UserProductReviewPageObject;
import pageObjects.nopcommerce.UserRegisterPageObject;
import pageObjects.nopcommerce.UserRewardPageObject;

public class Level_008_Page_Navigation extends BaseTest{
	
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfoPage;
	UserOrdersPageObject orderPage;
	UserRewardPageObject rewardPage;
	UserProductReviewPageObject productReviewPage;
	//String osName = System.getProperty("os.name");
	String emailAddress;
	
	@Parameters({"browser","userURL"})
	@BeforeClass
	public void beforeClass(String browserName, String userURL) {
		driver = getBrowserDriver(browserName,userURL);
		emailAddress = "lukephan" + generateRandomNumber() + "@auto.vn";
		homePage = PageGeneratorManager.getUserHomePage(driver);

	}
	
	@Test
	public void User_01_Register() {
		//Click on Register button
		homePage.clickToRegisterButton();
		registerPage = PageGeneratorManager.getUserRegisterPage(driver);
		
		//Select gender
		registerPage.clickToGenderMaleRadio();
		
		//Input first name & last name
		registerPage.inputToFirstNameTextbox("Luke");
		registerPage.inputToLastNameTextbox("Phan");
		
		//Select birthday
		registerPage.selectDayDropdown("28");
		registerPage.selectMonthDropdown("January");
		registerPage.selectYearDropdown("1991");
		
		//Input email address
		registerPage.inputToEmailTextbox(emailAddress);
		
		//Input & confirm password
		registerPage.inputToCompanyTextbox("Marvel");
		registerPage.inputToPasswordTextbox("qqqq1111");
		registerPage.inputToConfirmPasswordTextbox("qqqq1111");
		
		//Click REGISTER button
		registerPage.clickToRegisterButton();
		
		//Verify success message
		Assert.assertEquals(registerPage.getRegisterResultMessage(), "Your registration completed");
		
		//logout of current account
		registerPage.clickToContinueButton();
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		Assert.assertEquals(homePage.getHomePageURL(), "https://demo.nopcommerce.com/");
	}
	
	@Test
	public void User_02_Login() {
		//click on login button
		homePage.clickToLoginLink();
		
		//input Email address & password
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("qqqq1111");
		
		//submit login
		loginPage.clickToLoginButton();
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		homePage.clickToMyAccountLink();
		//customerInfoPage = new CustomerInfoPageObject(driver);
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		
		Assert.assertTrue(customerInfoPage.isGenderMaleRadioSelected());
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxAttribute("value"), "Luke");
		Assert.assertEquals(customerInfoPage.getLastNameTextboxAttribute("value"), "Phan");
		Assert.assertEquals(customerInfoPage.getDayDropdownSelectedItem(), "28");
		Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedItem(), "January");
		Assert.assertEquals(customerInfoPage.getYearDropdownSelectedItem(), "1991");
		Assert.assertEquals(customerInfoPage.getEmailTextboxAttribute("value"), emailAddress);
		Assert.assertEquals(customerInfoPage.getCompanyTextboxAttribute("value"), "Marvel");
	}
	
	@Test
	public void User_03_Navigate() {
		orderPage = customerInfoPage.openOrderPage(driver); 
		
		productReviewPage = orderPage.openProductReviewPage(driver);
		
		rewardPage = productReviewPage.openRewardPage(driver);
		
		orderPage = rewardPage.openOrderPage(driver);
		
		rewardPage = orderPage.openRewardPage(driver);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
