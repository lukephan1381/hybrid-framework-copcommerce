package com.nopcommerce.users;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

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
import reportConfig.ExtentTestManager;

public class Level_015_ExtentV5_Screenshot extends BaseTest{
	
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
	public void User_01_Register(Method method) {
		//Click on Register button
		ExtentTestManager.startTest(method.getName(), "User_01_Register");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to REGISTER page");
		registerPage = homePage.clickToRegisterButton();
		
		//Select gender
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click on Male radio button");
		registerPage.clickToGenderMaleRadio();
		
		//Input first name & last name
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Input to firstname textbox");
		registerPage.inputToFirstNameTextbox("Luke");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Input to lastname textbox");
		registerPage.inputToLastNameTextbox("Phan");
		
		//Select birthday
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Select birthday day");
		registerPage.selectDayDropdown("28");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Select birthday month");
		registerPage.selectMonthDropdown("January");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Select birthday year");
		registerPage.selectYearDropdown("1991");
		
		//Input email address
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Input to email address textbox");
		registerPage.inputToEmailTextbox(emailAddress);
		
		//Input & confirm password
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 09: Input to company textbox");
		registerPage.inputToCompanyTextbox("Marvel");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 10: Input to password textbox");
		registerPage.inputToPasswordTextbox("qqqq1111");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 11: Input to confirm password textbox");
		registerPage.inputToConfirmPasswordTextbox("qqqq1111");
		
		//Click REGISTER button
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 12: Click to REGISTER button");
		registerPage.clickToRegisterButton();
		
		//Verify success message
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 13: Verify if register completed");
		Assert.assertEquals(registerPage.getRegisterResultMessage(), "Your registration completed");
		
		//logout of current account
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 14: Return to HOME page");
		//registerPage.clickToContinueButton();
		
		homePage = registerPage.clickToContinueButton();
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 15: Return to HOME page successfully");
		Assert.assertEquals(homePage.getHomePageURL(), "https://demo.nopcommerce.com/");	
	}
	
	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Login");
		//click on login button
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Click to LOGIN link");
		loginPage = homePage.clickToLoginLink();
		
		//input Email address & password
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input Email and Password");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("qqqq1111");
		
		//submit login
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Click to LOGIN button");
		loginPage.clickToLoginButton();
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Check if Login successfully");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		homePage.clickToMyAccountLink();
		//customerInfoPage = new CustomerInfoPageObject(driver);
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Check if Male radio button is selected");
		Assert.assertFalse(customerInfoPage.isGenderMaleRadioSelected());
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Check if firstname match registered info");
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxAttribute("value"), "Luke");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 07: Check if last match registered info");
		Assert.assertEquals(customerInfoPage.getLastNameTextboxAttribute("value"), "Phan.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 08: Check if date of birth match registered info");
		Assert.assertEquals(customerInfoPage.getDayDropdownSelectedItem(), "28");
		Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedItem(), "January.");
		Assert.assertEquals(customerInfoPage.getYearDropdownSelectedItem(), "1991");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 09: Check if email address match registered info");
		Assert.assertEquals(customerInfoPage.getEmailTextboxAttribute("value"), emailAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 10: Check if company name match registered info");
		Assert.assertEquals(customerInfoPage.getCompanyTextboxAttribute("value"), "Marvel");
	}
	

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
