package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.UserCustomerInfoPageObject;
import pageObjects.UserHomePageObject;
import pageObjects.UserLoginPageObject;
import pageObjects.UserOrdersPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.UserProductReviewPageObject;
import pageObjects.UserRegisterPageObject;
import pageObjects.UserRewardPageObject;

public class User_01_Level_9_Switch_Role extends BaseTest{
	
	String githubToken = "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";
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfoPage;
	UserOrdersPageObject orderPage;
	UserRewardPageObject rewardPage;
	UserProductReviewPageObject productReviewPage;
	//String osName = System.getProperty("os.name");
	String userUsername, userPassword, adminUsername, adminPassword;
	String userURL, adminURL;
	
	@Parameters({"browser","userURL","adminURL"})
	@BeforeClass
	public void beforeClass(String browserName, String userURL, String adminURL) {
		driver = getBrowserDriver(browserName, userURL);
		userUsername = "lukephan" + generateRandomNumber() + "@auto.vn";
		userPassword = "qqqq1111";
		adminUsername = "admin@yourstore.com";
		adminPassword = "admin";
		this.userURL = userURL;
		this.adminURL = adminURL;
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		homePage.clickToRegisterButton();
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
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
		registerPage.inputToEmailTextbox(userUsername);
		
		//Input & confirm password
		registerPage.inputToCompanyTextbox("Marvel");
		registerPage.inputToPasswordTextbox("qqqq1111");
		registerPage.inputToConfirmPasswordTextbox("qqqq1111");
		
		//Click REGISTER button
		registerPage.clickToRegisterButton();
		
		//Verify success message
		//Assert.assertEquals(registerPage.getRegisterResultMessage(), "Your registration completed");
		
		//logout of current account
		registerPage.clickToContinueButton();
		
		homePage = PageGeneratorManager.getHomePage(driver);
		//Assert.assertEquals(homePage.getHomePageURL(), "https://demo.nopcommerce.com/");

	}
	
	@Test
	public void Role_01_User_To_Admin() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(userUsername);
		loginPage.inputToPasswordTextbox(userPassword);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		homePage.openURL(driver, this.adminURL);
	}
	
	@Test
	public void Role_02_Admin_to_User() {

	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
