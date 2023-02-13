package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.UserHomePageObject;
import pageObjects.UserLoginPageObject;
import pageObjects.AdminDashboardPageObject;
import pageObjects.AdminLoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.UserCustomerInfoPageObject;
import pageObjects.UserRegisterPageObject;

public class User_01_Level_9_Switch_Role extends BaseTest{
	
	String githubToken = "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";
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	UserCustomerInfoPageObject userCustomerInfoPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
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
		
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		userHomePage.clickToRegisterButton();
		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
		
		//Select gender
		userRegisterPage.clickToGenderMaleRadio();
		
		//Input first name & last name
		userRegisterPage.inputToFirstNameTextbox("Luke");
		userRegisterPage.inputToLastNameTextbox("Phan");
		
		//Select birthday
		userRegisterPage.selectDayDropdown("28");
		userRegisterPage.selectMonthDropdown("January");
		userRegisterPage.selectYearDropdown("1991");
		
		//Input email address
		userRegisterPage.inputToEmailTextbox(userUsername);
		
		//Input & confirm password
		userRegisterPage.inputToCompanyTextbox("Marvel");
		userRegisterPage.inputToPasswordTextbox("qqqq1111");
		userRegisterPage.inputToConfirmPasswordTextbox("qqqq1111");
		
		//Click REGISTER button
		userRegisterPage.clickToRegisterButton();
		
		//Verify success message
		//Assert.assertEquals(registerPage.getRegisterResultMessage(), "Your registration completed");
		
		//logout of current account
		userRegisterPage.clickToContinueButton();
		
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		//Assert.assertEquals(homePage.getHomePageURL(), "https://demo.nopcommerce.com/");

	}
	
	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.inputToEmailTextbox(userUsername);
		userLoginPage.inputToPasswordTextbox(userPassword);
		userHomePage = userLoginPage.clickToLoginButton();
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		
		userHomePage.openURL(driver, this.adminURL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminLoginPage.inputToEmailTextbox(adminUsername);
		adminLoginPage.inputToPasswordTextbox(adminPassword);
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}
	
	@Test
	public void Role_02_Admin_to_User() {
		//From Admin navigate to User page by URL
		adminDashboardPage.openURL(driver, this.userURL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		adminDashboardPage.sleepInSecond(3);
		
		//User actions
		userHomePage.clickToMyAccountLink();
		userCustomerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		
		Assert.assertTrue(userCustomerInfoPage.isGenderMaleRadioSelected());
		Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxAttribute("value"), "Luke");
		Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxAttribute("value"), "Phan");
		Assert.assertEquals(userCustomerInfoPage.getDayDropdownSelectedItem(), "28");
		Assert.assertEquals(userCustomerInfoPage.getMonthDropdownSelectedItem(), "January");
		Assert.assertEquals(userCustomerInfoPage.getYearDropdownSelectedItem(), "1991");
		Assert.assertEquals(userCustomerInfoPage.getEmailTextboxAttribute("value"), userUsername);
		Assert.assertEquals(userCustomerInfoPage.getCompanyTextboxAttribute("value"), "Marvel");
		
		//User Customer Info -> Admin
		userCustomerInfoPage.openURL(driver, this.adminURL);
		adminDashboardPage = PageGeneratorManager.getAdminDashboardPage(driver);
		adminDashboardPage.sleepInSecond(3);
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
