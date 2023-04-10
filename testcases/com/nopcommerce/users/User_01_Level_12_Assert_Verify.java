package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import nopcommerce_pageObjects.PageGeneratorManager;
import nopcommerce_pageObjects.UserCustomerInfoPageObject;
import nopcommerce_pageObjects.UserHomePageObject;
import nopcommerce_pageObjects.UserLoginPageObject;
import nopcommerce_pageObjects.UserOrdersPageObject;
import nopcommerce_pageObjects.UserProductReviewPageObject;
import nopcommerce_pageObjects.UserRegisterPageObject;
import nopcommerce_pageObjects.UserRewardPageObject;
import nopcommerce_pageObjects.UserSideBarPageObject;

public class User_01_Level_12_Assert_Verify extends BaseTest{
	
	String githubToken = "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";
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
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		homePage.clickToMyAccountLink();
		//customerInfoPage = new CustomerInfoPageObject(driver);
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		
		verifyFalse(customerInfoPage.isGenderMaleRadioSelected());
		verifyEquals(customerInfoPage.getFirstNameTextboxAttribute("value"), "Luke");
		verifyEquals(customerInfoPage.getLastNameTextboxAttribute("value"), "Phan");
		verifyEquals(customerInfoPage.getDayDropdownSelectedItem(), "28");
		verifyEquals(customerInfoPage.getMonthDropdownSelectedItem(), "January.");
		verifyEquals(customerInfoPage.getYearDropdownSelectedItem(), "1991.");
		verifyEquals(customerInfoPage.getEmailTextboxAttribute("value"), emailAddress);
		verifyEquals(customerInfoPage.getCompanyTextboxAttribute("value"), "Marvel");
	}
	
	//@Test
	public void User_03_Navigate() {

		orderPage = (UserOrdersPageObject) customerInfoPage.openSideBarPageByName("Orders");

		productReviewPage = (UserProductReviewPageObject) orderPage.openSideBarPageByName("My product reviews");

		rewardPage = (UserRewardPageObject) productReviewPage.openSideBarPageByName("Reward points");
		
		orderPage = (UserOrdersPageObject) rewardPage.openSideBarPageByName("Orders");

		rewardPage = (UserRewardPageObject) orderPage.openSideBarPageByName("Reward points");

	}
	
	//@Test
	public void User_04_Navigate() {
		rewardPage.openSideBarPageByPageName("Orders");
		orderPage = PageGeneratorManager.getUserOrdersPage(driver);
		
		orderPage.openSideBarPageByPageName("Customer info");
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		
		customerInfoPage.openSideBarPageByPageName("My product reviews");
		productReviewPage = PageGeneratorManager.getUserProductReviewPage(driver);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
