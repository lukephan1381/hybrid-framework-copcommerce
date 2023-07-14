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
import pageObjects.nopcommerce.UserSideBarPageObject;

public class Level_017_Custom_Close_Driver extends BaseTest{
	
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfoPage;
	UserOrdersPageObject orderPage;
	UserRewardPageObject rewardPage;
	UserProductReviewPageObject productReviewPage;
	UserSideBarPageObject userSideBar;
	//String osName = System.getProperty("os.name");
	String emailAddress,password,firstName,lastName;
	
	@Parameters({"browser","userURL"})
	@BeforeClass
	public void beforeClass(String browserName, String userURL) {
		driver = getBrowserDriver(browserName,userURL);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Luke";
		lastName = "Phan";
		emailAddress = "lukephan" + generateRandomNumber() + "@auto.vn";
		password = "qqqq1111";

		log.info("Register - Step 01: Navigate to REGISTER page");
		registerPage = homePage.clickToRegisterButton();
		
		log.info("Register - Step 03: Input to firstname textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		log.info("Register - Step 04: Input to lastname textbox");
		registerPage.inputToLastNameTextbox(lastName);
		log.info("Register - Step 05: Input to email address textbox");
		registerPage.inputToEmailTextbox(emailAddress);
		log.info("Register - Step 06: Input to password textbox");
		registerPage.inputToPasswordTextbox(password);
		log.info("Register - Step 07: Input to confirm password textbox");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register - Step 07: Click to REGISTER button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 09: Verify if register completed");
		Assert.assertEquals(registerPage.getRegisterResultMessage(), "Your registration completed");
		
		log.info("Register - Step 10: click on CONTINUE button");
		homePage = registerPage.clickToContinueButton();
		
		log.info("Register - Step 11: Return to HOME page successfully");
		Assert.assertEquals(homePage.getHomePageURL(), "https://demo.nopcommerce.com/");
		
		log.info("Login - Step 12: Click to LOGIN link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 13: Input Email and Password");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 14: Click to LOGIN button");
		homePage = loginPage.clickToLoginButton();
	}
	
	@Test
	public void User_01_Register() {
	}
	
	@Test
	public void User_02_Login() {
	}

	
	@AfterClass(alwaysRun=true)
	public void afterClass() {
		closeBrowserDriver();
	}
	

	
}
