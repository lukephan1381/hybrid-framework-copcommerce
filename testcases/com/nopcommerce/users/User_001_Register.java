package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.UserHomePageObject;
import pageObjects.nopcommerce.UserRegisterPageObject;

public class User_001_Register extends BaseTest{
	
	@Parameters({"browser","userURL"})
	@BeforeClass
	public void beforeClass(String browserName, String userURL) {
		emailAddress = "lukephan" + generateRandomNumber() + "@auto.vn";
		password = "qqqq1111";
		driver = getBrowserDriver(browserName,userURL);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}
	
	@Test
	public void Register_001_Empty_Data() {
		log.info("Register 001 - Step 01: Navigate to Register page");
		registerPage = homePage.clickToRegisterButton();
		log.info("Register 001 - Step 02: Click on Register button");
		registerPage.clickToRegisterButton();
		log.info("Register 001 - Step 03: Check error message on Firstname field");
		Assert.assertEquals(registerPage.getErrorMessageEmptyFirstname(), "First name is required.");
		log.info("Register 001 - Step 04: Check error message on Lastname field");
		Assert.assertEquals(registerPage.getErrorMessageEmptyLastname(), "Last name is required.");
		log.info("Register 001 - Step 05: Check error message on Email field");
		Assert.assertEquals(registerPage.getErrorMessageEmptyEmail(), "Email is required.");
		log.info("Register 001 - Step 06: Check error message on Password field");
		Assert.assertEquals(registerPage.getErrorMessageEmptyPassword(), "Password is required.");
		log.info("Register 001 - Step 07: Check error message on Confirm password field");
		Assert.assertEquals(registerPage.getErrorMessageEmptyConfirmPassword(), "Password is required.");
	}
	
	@Test
	public void Register_002_Wrong_Email() {
		log.info("Register 001 - Step 01: Navigate to Register page");
		registerPage = homePage.clickToRegisterButton();
		log.info("Register 001 - Step 02: Input invalid email address");
		registerPage.inputToEmailTextbox("123");
		log.info("Register 001 - Step 02: Input invalid email address");
		Assert.assertEquals(registerPage.getErrorMessageWrongEmail(), "Wrong email");
	}
	
	@Test
	public void Register_003_Register_Successful() {
		//Click on Register button
		registerPage = homePage.clickToRegisterButton();
		
		//Input first name & last name
		registerPage.inputToFirstNameTextbox("Luke");
		registerPage.inputToLastNameTextbox("Phan");
		
		//Input email address
		registerPage.inputToEmailTextbox(emailAddress);
		
		//Input & confirm password
		registerPage.inputToPasswordTextbox("qqqq1111");
		registerPage.inputToConfirmPasswordTextbox("qqqq1111");
		
		//Click REGISTER button
		registerPage.clickToRegisterButton();
		
		//Verify success message
		Assert.assertEquals(registerPage.getRegisterResultMessage(), "Your registration completed");
	}
	
	@Test
	public void Register_004_Exist_Email() {
		registerPage = homePage.clickToRegisterButton();
		
		//Input first name & last name
		registerPage.inputToFirstNameTextbox("Luke");
		registerPage.inputToLastNameTextbox("Phan");
				
		//Input email address
		registerPage.inputToEmailTextbox("steve_gates@nopCommerce.com");
				
		//Input & confirm password
		registerPage.inputToPasswordTextbox("qqqq1111");
		registerPage.inputToConfirmPasswordTextbox("qqqq1111");
				
		//Click REGISTER button
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageExistEmail(), "The specified email already exists");
	}
	
	@Test
	public void Register_005_6char_Password() {
		//Click on Register button
		registerPage = homePage.clickToRegisterButton();
		
		//Input first name & last name
		registerPage.inputToFirstNameTextbox("Luke");
		registerPage.inputToLastNameTextbox("Phan");
		
		//Input email address
		registerPage.inputToEmailTextbox(emailAddress);
		
		//Input & confirm password
		registerPage.inputToPasswordTextbox("qqqq");
		registerPage.inputToConfirmPasswordTextbox("qqqq");
		
		//Click REGISTER button
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageAtLeast6CharPassword(), "Password must meet the following rules: must have at least 6 characters");
		Assert.assertTrue(registerPage.getErrorMessageAtLeast6CharPassword().contains("Password must meet the following rules: must have at least 6 characters"));
	}
	
	@Test
	public void Register_006_Password_Not_Match() {
		//Click on Register button
		registerPage = homePage.clickToRegisterButton();
				
		//Input first name & last name
		registerPage.inputToFirstNameTextbox("Luke");
		registerPage.inputToLastNameTextbox("Phan");
				
		//Input email address
		registerPage.inputToEmailTextbox(emailAddress);
				
		//Input & confirm password
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("1111qqqq");
		Assert.assertEquals(registerPage.getErrorMessagePasswordNotMatch(), "The password and confirmation password do not match.");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	String emailAddress,password;
}
