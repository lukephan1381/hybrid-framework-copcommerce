package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.UserHomePageObject;
import pageObjects.nopcommerce.UserProductPageObject;

public class User_005_Sort_Display_Page extends BaseTest{
	
	@Parameters({"browser","userURL"})
	@BeforeClass()
	public void beforeClass(String browser, String userURL) {
		driver = getBrowserDriver(browser, userURL);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		homePage.openHeaderPageByPageName("Notebooks ");
		
		productPage = PageGeneratorManager.getUserProductPage(driver);
	}
	
	@Test
	public void TC_001_Sort_A_To_Z() {
		productPage.selectSortTypeByText("Name: A to Z");
		productPage.getListOfProducts();
		
	}
	
	@AfterClass()
	public void afterClass() {
		driver.quit();
	}
	
	WebDriver driver;
	UserHomePageObject homePage;
	UserProductPageObject productPage;
}
