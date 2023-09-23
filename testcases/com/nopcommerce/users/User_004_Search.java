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
import pageObjects.nopcommerce.UserSearchPageObject;

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
		homePage.clickToSearchLink();
		searchPage = PageGeneratorManager.getUserSearchPageObject(driver);
		
		searchPage.inputToSearchTextbox("");
		searchPage.clickToSearchbutton();		
		Assert.assertEquals(searchPage.getSearchEmptyErrorMessage(), "Search term minimum length is 3 characters");
	}
	
	@Test
	public void Search_002_Product_Not_Exist() {
		homePage.clickToSearchLink();
		searchPage = PageGeneratorManager.getUserSearchPageObject(driver);
		
		searchPage.inputToSearchTextbox("free");
		searchPage.clickToSearchbutton();
		Assert.assertEquals(searchPage.getSearchNoProductErrorMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void Search_003_Partially_Match_Product() {
		homePage.clickToSearchLink();
		searchPage = PageGeneratorManager.getUserSearchPageObject(driver);
		
		searchPage.inputToSearchTextbox("Lenovo");
		searchPage.clickToSearchbutton();
		searchPage.getListOfResults();

		for (int i = 0; i < searchPage.getListOfResults().size(); i++) {
			Assert.assertTrue(searchPage.getListOfResults().get(i).getText().contains("Lenovo"));
		}
	}
	
	@Test
	public void Search_004_Exact_Match_Product() {
		homePage.clickToSearchLink();
		searchPage = PageGeneratorManager.getUserSearchPageObject(driver);
		
		searchPage.inputToSearchTextbox("Thinkpad X1 Carbon");
		searchPage.clickToSearchbutton();
		searchPage.getListOfResults();

		for (int i = 0; i < searchPage.getListOfResults().size(); i++) {
			Assert.assertEquals(searchPage.getListOfResults().get(i).getText(), "Thinkpad X1 Carbon");
		}
	}
	
	@Test
	public void Search_005_Advanced_Parent_Category() {
		homePage.clickToSearchLink();
		searchPage = PageGeneratorManager.getUserSearchPageObject(driver);
		
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		searchPage.checkOnAdvancedSearchCheckbox();
		searchPage.selectCategoryByText("Computers");
		searchPage.clickToSearchbutton();
		Assert.assertEquals(searchPage.getSearchNoProductErrorMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void Search_006_Advanced_Sub_Category() {
		homePage.clickToSearchLink();
		searchPage = PageGeneratorManager.getUserSearchPageObject(driver);
		
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		searchPage.checkOnAdvancedSearchCheckbox();
		searchPage.selectCategoryByText("Computers");
		searchPage.checkOnSearchSubCategoryCheckbox();
		searchPage.clickToSearchbutton();
		searchPage.getListOfResults();

		//for each element in results
		//assertEqual(element.getText(), 'Apple MacBook Pro 13-inch')
		for (int i = 0; i < searchPage.getListOfResults().size(); i++) {
			Assert.assertEquals(searchPage.getListOfResults().get(i).getText(), "Apple MacBook Pro 13-inch");
		}
	}
	
	@Test
	public void Search_007_Advanced_Incorrect_Manufacturer() {
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		searchPage.checkOnAdvancedSearchCheckbox();
		searchPage.selectCategoryByText("Computers");
		searchPage.checkOnSearchSubCategoryCheckbox();
		searchPage.selectManufacturerByText("HP");
		searchPage.clickToSearchbutton();
		Assert.assertEquals(searchPage.getSearchNoProductErrorMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void Search_008_Advanced_Correct_Manufacturer() {
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		searchPage.checkOnAdvancedSearchCheckbox();
		searchPage.selectCategoryByText("Computers");
		searchPage.checkOnSearchSubCategoryCheckbox();
		searchPage.selectManufacturerByText("Apple");
		searchPage.clickToSearchbutton();
		searchPage.getListOfResults();
		
		for (int i = 0; i < searchPage.getListOfResults().size(); i++) {
			Assert.assertEquals(searchPage.getListOfResults().get(i).getText(), "Apple MacBook Pro 13-inch");
		}
	}
	
	@AfterClass()
	public void afterClass() {
		driver.quit();
	}
	
	WebDriver driver;
	String emailAddress, password;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserSearchPageObject searchPage;
}
