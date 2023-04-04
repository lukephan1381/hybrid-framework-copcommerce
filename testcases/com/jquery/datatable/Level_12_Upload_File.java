package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import jquery_uploadfile_pageObjects.HomePageObject;
import jquery_uploadfile_pageObjects.PageGeneratorManager;


public class Level_12_Upload_File extends BaseTest{
	
	String githubToken = "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";
	WebDriver driver;
	HomePageObject homePage;
	String behoa = "behoa.PNG";
	String bevo = "bevo.PNG";
	String nam = "nam.PNG";
	String[] multipleFiles = {behoa, bevo, nam};
	
	@Parameters({"browser","userURL"})
	@BeforeClass
	public void beforeClass(String browserName, String userURL) {
		driver = getBrowserDriver(browserName,userURL);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	@Test
	public void Upload_01_One_File() {
		homePage.uploadMultipleFiles(driver, behoa);
		Assert.assertTrue(homePage.isFileLoadedByName(behoa));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUploadedByName(behoa));
		Assert.assertTrue(homePage.isFileImageUploadedByName(behoa));
	}
	
	@Test
	public void Upload_02_Multiple_Files() {
		homePage.pageRefresh(driver);
		homePage.uploadMultipleFiles(driver, multipleFiles);
		
		Assert.assertTrue(homePage.isFileLoadedByName(behoa));
		Assert.assertTrue(homePage.isFileLoadedByName(bevo));
		Assert.assertTrue(homePage.isFileLoadedByName(nam));
		
		homePage.clickToStartButton();
		
		Assert.assertTrue(homePage.isFileLinkUploadedByName(behoa));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(bevo));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(nam));
		
		Assert.assertTrue(homePage.isFileImageUploadedByName(behoa));
		Assert.assertTrue(homePage.isFileImageUploadedByName(bevo));
		Assert.assertTrue(homePage.isFileImageUploadedByName(nam));
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
