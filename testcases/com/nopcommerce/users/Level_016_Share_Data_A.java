package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

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

public class Level_016_Share_Data_A extends BaseTest{
	
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
	String emailAddress,password;
	
	@Parameters({"browser","userURL"})
	@BeforeClass
	public void beforeClass(String browserName, String userURL) {
		driver = getBrowserDriver(browserName,userURL);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = Common_01_Register.emailAddress;
		password = Common_01_Register.password;
		
		log.info("Login - Step 01: Click to LOGIN link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Input Email and Password");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 03: Click to LOGIN button");
		loginPage.clickToLoginButton();
	}
	
	@Test
	public void Search_01_Empty_Data() {

	}
	
	@Test
	public void Search_02_Relative_Product_Name() {

	}
	
	@Test
	public void Search_03_Absolute_Product_Name() {

	}
	
	@Test
	public void Search_04_Parent_Category() {

	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
