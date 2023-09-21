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

public class User_004_Search extends BaseTest{
	
	@Parameters({"browser","userURL"})
	@BeforeClass()
	public void beforeClass(String browser, String userURL) {
		driver = getBrowserDriver(browser, userURL);
		
		emailAddress = Common_01_Register.emailAddress;
		password = Common_01_Register.password;
		
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void Search_001_Empty_Data() {

	}
	
	@Test
	public void Search_002_Product_Not_Exist() {
		
	}
	
	@Test
	public void Search_003_Partially_Match_Product() {
		
	}
	
	@Test
	public void Search_004_Exact_Match_Product() {
		
	}
	
	@Test
	public void Search_005_Advanced_Parent_Category() {
		
	}
	
	@Test
	public void Search_006_Advanced_Sub_Category() {
		
	}
	
	@Test
	public void Search_007_Advanced_Incorrect_Manufacturer() {
		
	}
	
	@Test
	public void Search_008_Advanced_Correct_Manufacturer() {
		
	}
	
	@AfterClass()
	public void afterClass() {
		driver.quit();
	}
	
	WebDriver driver;
	String emailAddress, password;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
}
