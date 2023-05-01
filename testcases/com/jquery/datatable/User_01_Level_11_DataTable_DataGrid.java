package com.jquery.datatable;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;


public class User_01_Level_11_DataTable_DataGrid extends BaseTest{
	
	WebDriver driver;
	HomePageObject homePage;
	List<String> allCountryValues;
	//String osName = System.getProperty("os.name");
	
	@Parameters({"browser","userURL"})
	@BeforeClass
	public void beforeClass(String browserName, String userURL) {
		driver = getBrowserDriver(browserName,userURL);
		homePage = PageGeneratorManager.getHomePage(driver);

	}
	
	//@Test
	public void Table_01_Paging() {
		homePage.openPageByPageNumber("2");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("2"));
		
		homePage.openPageByPageNumber("3");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("3"));
		
		homePage.openPageByPageNumber("4");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("4"));
		
		homePage.openPageByPageNumber("5");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("5"));
	}
	
	//@Test
	public void Table_02_Input_To_Header() {
		homePage.pageRefresh(driver);
		
		homePage.inputToHeaderTextboxByLabel("Females","777");
		homePage.inputToHeaderTextboxByLabel("Country","Antigua and Barbuda");
		homePage.inputToHeaderTextboxByLabel("Males","803");
		homePage.inputToHeaderTextboxByLabel("Total","1580");
		homePage.sleepInSecond(3);
		
		homePage.inputToHeaderTextboxByLabel("Females","50782");
		homePage.inputToHeaderTextboxByLabel("Country","Libya");
		homePage.inputToHeaderTextboxByLabel("Males","52972");
		homePage.inputToHeaderTextboxByLabel("Total","103757");
		homePage.sleepInSecond(3);
	}
	
	//@Test
	public void User_03_Input_To_Header() {
		homePage.pageRefresh(driver);
		homePage.getRowValuesAtAllPage();
	}
	
	@Test
	public void Table_04_Ation_At_Any_Row() {
		homePage.clickToLoadButton();
		
//		homePage.enterToTextboxByColumnNameAtRowNumber("Company","1","Fossil");
//		homePage.sleepInSecond(1);
//		
//		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person","1","Michel 97");
//		homePage.sleepInSecond(1);
//		
//		homePage.selectDropdownByColumnNameAtRowNumber("Country", "1", "Hong Kong");
//		homePage.sleepInSecond(1);
//		
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","2");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","3");
//		
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?","1");
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?","4");
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?","5");
		
		homePage.clickToIconByRowNumber("1","Remove Current Row");
		homePage.clickToIconByRowNumber("1","Insert Row Above");
		homePage.clickToIconByRowNumber("3","Move Up");
		
		homePage.clickToIconByRowNumber("5","Remove Current Row");
		homePage.clickToIconByRowNumber("4","Remove Current Row");
		homePage.clickToIconByRowNumber("3","Remove Current Row");
		homePage.clickToIconByRowNumber("2","Remove Current Row");
		homePage.clickToIconByRowNumber("1","Remove Current Row");
	}
	

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	
}
