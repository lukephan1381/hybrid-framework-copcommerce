package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

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

public class Common_01_Register_Cookie extends BaseTest{
	
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfoPage;
	UserOrdersPageObject orderPage;
	UserRewardPageObject rewardPage;
	UserProductReviewPageObject productReviewPage;
	UserSideBarPageObject userSideBar;
	private String firstName,lastName,emailAddress,password;
	public static Set<Cookie> loggedCookie;
	
	
	@Parameters({"browser","userURL"})
	@BeforeTest(description = "Create new common user for all Classes Test")
	public void Register(String browserName, String userURL) {
		
		driver = getBrowserDriver(browserName,userURL);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Luke";
		lastName = "Phan";
		emailAddress = "lukephan" + generateRandomNumber() + "@auto.vn";
		password = "qqqq1111";

		log.info("Register - Step 01: Navigate to REGISTER page");
		registerPage = homePage.clickToRegisterButton();
		
		log.info("Register - Step 02: Click on Male radio button");
		registerPage.clickToGenderMaleRadio();
		
		log.info("Register - Step 03: Input to firstname textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		log.info("Register - Step 04: Input to lastname textbox");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Register - Step 05: Select birthday day");
		registerPage.selectDayDropdown("28");
		log.info("Register - Step 06: Select birthday month");
		registerPage.selectMonthDropdown("January");
		log.info("Register - Step 07: Select birthday year");
		registerPage.selectYearDropdown("1991");
		

		log.info("Register - Step 08: Input to email address textbox");
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Register - Step 09: Input to company textbox");
		registerPage.inputToCompanyTextbox("Marvel");
		log.info("Register - Step 10: Input to password textbox");
		registerPage.inputToPasswordTextbox(password);
		log.info("Register - Step 11: Input to confirm password textbox");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register - Step 12: Click to REGISTER button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 13: Verify if register completed");
		Assert.assertEquals(registerPage.getRegisterResultMessage(), "Your registration completed");
		
		log.info("Register - Step 14: Return to HOME page");
		homePage = registerPage.clickToContinueButton();
		
		log.info("Register - Step 15: Return to HOME page successfully");
		Assert.assertEquals(homePage.getHomePageURL(), "https://demo.nopcommerce.com/");
		
		log.info("Login - Step 01: Click to LOGIN link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Input Email and Password");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 03: Click to LOGIN button");
		homePage = loginPage.clickToLoginButton();
		
		loggedCookie = homePage.getAllCookies(driver);
		
	}
	
	@AfterTest
	public void afterClass() {
		driver.quit();
	}
	

	
}
