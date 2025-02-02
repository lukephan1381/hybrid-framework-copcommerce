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

public class Level_016_Share_Data_B extends BaseTest{
	
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

		//Click on Register button
		log.info("Register - Step 01: Navigate to REGISTER page");
		registerPage = homePage.clickToRegisterButton();
		
		//Select gender
		log.info("Register - Step 02: Click on Male radio button");
		registerPage.clickToGenderMaleRadio();
		
		//Input first name & last name
		log.info("Register - Step 03: Input to firstname textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		log.info("Register - Step 04: Input to lastname textbox");
		registerPage.inputToLastNameTextbox(lastName);
		
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
		registerPage.inputToPasswordTextbox(password);
		log.info("Register - Step 11: Input to confirm password textbox");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		//Click REGISTER button
		log.info("Register - Step 12: Click to REGISTER button");
		registerPage.clickToRegisterButton();
		
		//Verify success message
		log.info("Register - Step 13: Verify if register completed");
		Assert.assertEquals(registerPage.getRegisterResultMessage(), "Your registration completed");
		
		//logout of current account
		log.info("Register - Step 14: Return to HOME page");
		homePage = registerPage.clickToContinueButton();
		
		log.info("Login - Step 01: Click to LOGIN link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Input Email and Password");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 03: Click to LOGIN button");
		loginPage.clickToLoginButton();
	}
	
	@Test
	public void Search_01_Empty_Data() {

	}
	
	@Test
	public void Search_02_Relative_Product_Name() {

	}
	
	@Test
	public void Search_03_Absolute_Product_Name() {

	}
	
	@Test
	public void Search_04_Parent_Category() {

	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
