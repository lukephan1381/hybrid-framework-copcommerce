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

public class Level_018_Pattern_Object extends BaseTest{
	
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
		log.info("Register - Step 01: Navigate to REGISTER page");
		registerPage = homePage.clickToRegisterButton();
		
		log.info("Register - Step 02: Click on Male radio button");
		registerPage.clickToRadioByLabel(driver,"Male");
		
		log.info("Register - Step 03: Input to firstname textbox");
		registerPage.inputToTextboxByID(driver,"FirstName","Luke");
		log.info("Register - Step 04: Input to lastname textbox");
		registerPage.inputToTextboxByID(driver,"LastName","Phan");

		log.info("Register - Step 05: Select birthday day");
		registerPage.selecToDropdownByName(driver,"DateOfBirthDay","28");
		log.info("Register - Step 06: Select birthday month");
		registerPage.selecToDropdownByName(driver,"DateOfBirthMonth","April");
		log.info("Register - Step 07: Select birthday year");
		registerPage.selecToDropdownByName(driver,"DateOfBirthYear","1991");
		
		log.info("Register - Step 08: Input to email address textbox");
		registerPage.inputToTextboxByID(driver,"Email",emailAddress);
		
		log.info("Register - Step 09: Input to company textbox");
		registerPage.inputToTextboxByID(driver,"Company","Marvel");
		
		log.info("Register - Step 10: Input to password textbox");
		registerPage.inputToTextboxByID(driver,"Password","qqqq1111");
		
		log.info("Register - Step 11: Input to confirm password textbox");
		registerPage.inputToTextboxByID(driver,"ConfirmPassword","qqqq1111");
		
		log.info("Register - Step 12: Click to REGISTER button");
		//registerPage.clickToRegisterButton();
		registerPage.clickToButtonByText(driver,"Register");
		
		log.info("Register - Step 13: Verify if register completed");
		Assert.assertEquals(registerPage.getRegisterResultMessage(), "Your registration completed");
		
		log.info("Register - Step 14: Return to HOME page");
		homePage = registerPage.clickToContinueButton();
		
		log.info("Register - Step 15: Return to HOME page successfully");
		Assert.assertEquals(homePage.getHomePageURL(), "https://demo.nopcommerce.com/");
	}
	
	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Click to LOGIN link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Input Email and Password");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		loginPage.inputToTextboxByID(driver, "Password", "qqqq1111");
		
		log.info("Login - Step 03: Click to LOGIN button");
		//loginPage.clickToLoginButton();
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Login - Step 04: Check if Login successfully");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void User_03_Customer_Info() {
		homePage.clickToMyAccountLink();
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		
		log.info("Login - Step 05: Check if Male radio button is selected");
		Assert.assertTrue(customerInfoPage.isGenderMaleRadioSelected());
		
		log.info("Login - Step 06: Check if firstname match registered info");
		Assert.assertEquals(customerInfoPage.getTextBoxValueByID(driver,"FirstName"),"Luke");
		
		log.info("Login - Step 07: Check if last match registered info");
		Assert.assertEquals(customerInfoPage.getTextBoxValueByID(driver,"LastName"),"Phan");
		
		log.info("Login - Step 08: Check if date of birth match registered info");
		//Assert.assertEquals(customerInfoPage.getDayDropdownSelectedItem(), "28");
		//Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedItem(), "April");
		//Assert.assertEquals(customerInfoPage.getYearDropdownSelectedItem(), "1991");
		
		Assert.assertEquals(customerInfoPage.getDropDownSelectedItemByName(driver,"DateOfBirthDay"),"28");
		Assert.assertEquals(customerInfoPage.getDropDownSelectedItemByName(driver,"DateOfBirthMonth"),"April");
		Assert.assertEquals(customerInfoPage.getDropDownSelectedItemByName(driver,"DateOfBirthYear"),"1991");
		
		log.info("Login - Step 09: Check if email address match registered info");
		Assert.assertEquals(customerInfoPage.getTextBoxValueByID(driver,"Email"), emailAddress);
		
		log.info("Login - Step 10: Check if company name match registered info");
		Assert.assertEquals(customerInfoPage.getTextBoxValueByID(driver,"Company"), "Marvel");
	}
	

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
