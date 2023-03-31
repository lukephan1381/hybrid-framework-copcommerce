package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import jquery_pageObjects.HomePageObject;
import jquery_pageObjects.PageGeneratorManager;


public class Level_12_Upload_File extends BaseTest{
	
	String githubToken = "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";
	WebDriver driver;
	
	@Parameters({"browser","userURL"})
	@BeforeClass
	public void beforeClass(String browserName, String userURL) {
		driver = getBrowserDriver(browserName,userURL);


	}
	
	//@Test
	public void Upload_01_One_File() {

	}
	
	//@Test
	public void Upload_02_Multiple_Files() {

	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
