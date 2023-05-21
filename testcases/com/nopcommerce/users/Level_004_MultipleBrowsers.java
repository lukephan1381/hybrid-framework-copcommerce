package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.UserHomePageObject;
import pageObjects.nopcommerce.UserLoginPageObject;
import pageObjects.nopcommerce.UserRegisterPageObject;

public class Level_004_MultipleBrowsers extends BaseTest{
	
	String githubToken = "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";
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfoPage;
	String osName = System.getProperty("os.name");
	String emailAddress;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, browserName);
		emailAddress = "lukephan" + generateRandomNumber() + "@auto.vn";

	}
	
	@Test
	public void User_01_Register() {
		//Click on Register button
		homePage = new UserHomePageObject(driver);
		homePage.clickToRegisterButton();
		
		
		registerPage = new UserRegisterPageObject(driver);
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
		registerPage.clickToLogoutLink();
		
		homePage = new UserHomePageObject(driver);
		Assert.assertEquals(homePage.getHomePageURL(), "https://demo.nopcommerce.com/");
	}
	
	@Test
	public void User_02_Login() {
		//click on login button
		homePage.clickToLoginLink();
		
		//input Email address & password
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("qqqq1111");
		
		//submit login
		loginPage.clickToLoginButton();
		
		homePage = new UserHomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		homePage.clickToMyAccountLink();
		customerInfoPage = new UserCustomerInfoPageObject(driver);
		
		Assert.assertTrue(customerInfoPage.isGenderMaleRadioSelected());
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxAttribute("value"), "Luke");
		Assert.assertEquals(customerInfoPage.getLastNameTextboxAttribute("value"), "Phan");
		Assert.assertEquals(customerInfoPage.getDayDropdownSelectedItem(), "28");
		Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedItem(), "January");
		Assert.assertEquals(customerInfoPage.getYearDropdownSelectedItem(), "1991");
		Assert.assertEquals(customerInfoPage.getEmailTextboxAttribute("value"), emailAddress);
		Assert.assertEquals(customerInfoPage.getCompanyTextboxAttribute("value"), "Marvel");
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
