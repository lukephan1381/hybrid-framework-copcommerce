package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import commons.BaseTest;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.UserHomePageObject;
import pageObjects.nopcommerce.UserLoginPageObject;

public class User_002_Login extends BaseTest {
	
	@Parameters({"browser,userURL"})
	@BeforeClass
	public void beforeClass(String browser, String userURL) {
		driver = getBrowserDriver(browser, userURL);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = Common_01_Register.emailAddress;
		password = Common_01_Register.password;
	}
	
	@Test
	public void Login_001_Empty_Email() {
		loginPage = homePage.clickToLoginLink();
		loginPage.clickToButtonByText(driver, "Log in");
		Assert.assertEquals(loginPage.getErrorMessageEmptyEmail(), "Please enter your email");
	}
	
	@Test
	public void Login_002_Wrong_Email() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox("123");
		loginPage.clickToButtonByText(driver, "Log in");
		Assert.assertEquals(loginPage.getErrorMessageWrongEmail(), "Wrong email");
	}
	
	@Test
	public void Login_003_Empty_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.clickToButtonByText(driver, "Log in");
		Assert.assertEquals(loginPage.getErrorMessageEmptyPassword(), "Wrong email");
	}
	
	@Test
	public void Login_004_Incorrect_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("123123123");
		loginPage.clickToButtonByText(driver, "Log in");
		Assert.assertEquals(loginPage.getErrorMessageIncorrectPassword(), "Wrong email");
	}
	
	@Test
	public void Login_005_Successful() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	String emailAddress,password;
}
