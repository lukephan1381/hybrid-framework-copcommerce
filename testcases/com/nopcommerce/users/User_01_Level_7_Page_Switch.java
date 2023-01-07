package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.OrdersPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.ProductReviewPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPageObject;

public class User_01_Level_7_Page_Switch extends BaseTest{
	
	String githubToken = "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";
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoPageObject customerInfoPage;
	OrdersPageObject orderPage;
	RewardPageObject rewardPage;
	ProductReviewPageObject productReviewPage;
	//String osName = System.getProperty("os.name");
	String emailAddress;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		emailAddress = "lukephan" + generateRandomNumber() + "@auto.vn";
		homePage = PageGeneratorManager.getHomePage(driver);

	}
	
	@Test
	public void User_01_Register() {
		//Click on Register button
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
		
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertEquals(homePage.getHomePageURL(), "https://demo.nopcommerce.com/");
	}
	
	@Test
	public void User_02_Login() {
		//click on login button
		homePage.clickToLoginLink();
		
		//input Email address & password
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("qqqq1111");
		
		//submit login
		loginPage.clickToLoginButton();
		
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		homePage.clickToMyAccountLink();
		//customerInfoPage = new CustomerInfoPageObject(driver);
		customerInfoPage = PageGeneratorManager.getCustomerInfoPage(driver);
		
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
		orderPage = customerInfoPage.openOrderPage(); 
		
		productReviewPage = orderPage.openProductReviewPage();
		
		rewardPage = productReviewPage.openRewardPage();
		
		orderPage = rewardPage.openOrderPage();
		
		rewardPage = orderPage.openRewardPage();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
