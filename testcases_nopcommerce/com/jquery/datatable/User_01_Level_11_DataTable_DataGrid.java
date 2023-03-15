package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import jquery_pageObjects.HomePageObject;
import jquery_pageObjects.PageGeneratorManager;


public class User_01_Level_11_DataTable_DataGrid extends BaseTest{
	
	String githubToken = "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";
	WebDriver driver;
	HomePageObject homePage;
	//String osName = System.getProperty("os.name");
	
	@Parameters({"browser","userURL"})
	@BeforeClass
	public void beforeClass(String browserName, String userURL) {
		driver = getBrowserDriver(browserName,userURL);
		homePage = PageGeneratorManager.getHomePage(driver);

	}
	
	@Test
	public void Table_01_Paging() {
		homePage.openPageByPageNumber("2");
		homePage.sleepInSecond(3);
		
		homePage.openPageByPageNumber("3");
		homePage.sleepInSecond(3);
		
		homePage.openPageByPageNumber("4");
		homePage.sleepInSecond(3);
		
		homePage.openPageByPageNumber("5");
		homePage.sleepInSecond(3);
	}
	
	//@Test
	public void User_02_Login() {

	}
	
	//@Test
	public void User_03_Navigate() {


	}
	

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
