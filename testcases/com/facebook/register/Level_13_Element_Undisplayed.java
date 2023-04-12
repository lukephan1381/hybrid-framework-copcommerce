package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.uploadfile.HomePageObject;
import pageObjects.jquery.uploadfile.PageGeneratorManager;


public class Level_13_Element_Undisplayed extends BaseTest{
	
	String githubToken = "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";
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser","userURL"})
	@BeforeClass
	public void beforeClass(String browserName, String userURL) {
		driver = getBrowserDriver(browserName,userURL);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	

	

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
