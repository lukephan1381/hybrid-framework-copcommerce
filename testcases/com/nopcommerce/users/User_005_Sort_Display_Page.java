package com.nopcommerce.users;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.collect.Comparators;

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
		
		List<String> listOfProduct = new ArrayList<String>();
		for (int i = 0; i < productPage.getListOfProducts().size(); i++) {
			listOfProduct.add(productPage.getListOfProducts().get(i).getText());
		}

		Assert.assertTrue(Comparators.isInOrder(listOfProduct, Comparator.naturalOrder()));
	}
	
	@Test
	public void TC_002_Sort_Z_To_A() {
		productPage.selectSortTypeByText("Name: Z to A");
		productPage.getListOfProducts();
		
		List<String> listOfProduct = new ArrayList<String>();
		for (int i = 0; i < productPage.getListOfProducts().size(); i++) {
			listOfProduct.add(productPage.getListOfProducts().get(i).getText());
		}

		Assert.assertTrue(Comparators.isInOrder(listOfProduct, Comparator.reverseOrder()));
	}
	
	@AfterClass()
	public void afterClass() {
		driver.quit();
	}
	
	WebDriver driver;
	UserHomePageObject homePage;
	UserProductPageObject productPage;
}
