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

public class User_01_Level_15_ReportNG_Screenshot extends BaseTest{
	
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
		log.info("Register - Step 01: Navigate to REGISTER page");
		registerPage = homePage.clickToRegisterButton();
		
		//Select gender
		log.info("Register - Step 02: Click on Male radio button");
		registerPage.clickToGenderMaleRadio();
		
		//Input first name & last name
		log.info("Register - Step 03: Input to firstname textbox");
		registerPage.inputToFirstNameTextbox("Luke");
		log.info("Register - Step 04: Input to lastname textbox");
		registerPage.inputToLastNameTextbox("Phan");
		
		//Select birthday
		log.info("Register - Step 05: Select birthday day");
		registerPage.selectDayDropdown("28");
		log.info("Register - Step 06: Select birthday month");
		registerPage.selectMonthDropdown("January");
		log.info("Register - Step 07: Select birthday year");
		registerPage.selectYearDropdown("1991");
		
		//Input email address
		log.info("Register - Step 08: Input to email address textbox");
		registerPage.inputToEmailTextbox(emailAddress);
		
		//Input & confirm password
		log.info("Register - Step 09: Input to company textbox");
		registerPage.inputToCompanyTextbox("Marvel");
		log.info("Register - Step 10: Input to password textbox");
		registerPage.inputToPasswordTextbox("qqqq1111");
		log.info("Register - Step 11: Input to confirm password textbox");
		registerPage.inputToConfirmPasswordTextbox("qqqq1111");
		
		//Click REGISTER button
		log.info("Register - Step 12: Click to REGISTER button");
		registerPage.clickToRegisterButton();
		
		//Verify success message
		log.info("Register - Step 13: Verify if register completed");
		Assert.assertEquals(registerPage.getRegisterResultMessage(), "Your registration completed");
		
		//logout of current account
		log.info("Register - Step 14: Return to HOME page");
		//registerPage.clickToContinueButton();
		
		homePage = registerPage.clickToContinueButton();
		log.info("Register - Step 15: Return to HOME page successfully");
		Assert.assertEquals(homePage.getHomePageURL(), "https://demo.nopcommerce.com/");
	}
	
	@Test
	public void User_02_Login() {
		//click on login button
		log.info("Login - Step 01: Click to LOGIN link");
		loginPage = homePage.clickToLoginLink();
		
		//input Email address & password
		log.info("Login - Step 02: Input Email and Password");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("qqqq1111");
		
		//submit login
		log.info("Login - Step 03: Click to LOGIN button");
		loginPage.clickToLoginButton();
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		log.info("Login - Step 04: Check if Login successfully");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		homePage.clickToMyAccountLink();
		//customerInfoPage = new CustomerInfoPageObject(driver);
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		
		log.info("Login - Step 05: Check if Male radio button is selected");
		Assert.assertFalse(customerInfoPage.isGenderMaleRadioSelected());
		
		log.info("Login - Step 06: Check if firstname match registered info");
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxAttribute("value"), "Luke");
		
		log.info("Login - Step 07: Check if last match registered info");
		Assert.assertEquals(customerInfoPage.getLastNameTextboxAttribute("value"), "Phan.");
		
		log.info("Login - Step 08: Check if date of birth match registered info");
		Assert.assertEquals(customerInfoPage.getDayDropdownSelectedItem(), "28");
		Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedItem(), "January.");
		Assert.assertEquals(customerInfoPage.getYearDropdownSelectedItem(), "1991");
		
		log.info("Login - Step 09: Check if email address match registered info");
		Assert.assertEquals(customerInfoPage.getEmailTextboxAttribute("value"), emailAddress);
		
		log.info("Login - Step 10: Check if company name match registered info");
		Assert.assertEquals(customerInfoPage.getCompanyTextboxAttribute("value"), "Marvel");
	}
	

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
