package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;


public class Level_13_Element_Undisplayed extends BaseTest{
	
	WebDriver driver;
	LoginPageObject loginPage;
	
	@Parameters({"browser","userURL"})
	@BeforeClass
	public void beforeClass(String browserName, String userURL) {
		driver = getBrowserDriver(browserName,userURL);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}
	

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
		loginPage.enterToEmailAddressTextbox("automation@gmail.com");
		
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
		loginPage.sleepInSecond(3);
	}
	
	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM()	{
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(3);
		verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
	}	

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickToCloseButtonSignupForm();
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
