package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.nopcommerce.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.UserHomePageObject;
import pageObjects.nopcommerce.UserLoginPageObject;
import pageObjects.nopcommerce.UserRegisterPageObject;

public class Level_002 {
	
	String githubToken = "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";
	WebDriver driver;
	BasePage basepage = new BasePage();
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfoPage;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Select select;
	String emailAddress = "lukephan" + generateRandomNumber() + "@auto.vn";
	
	@BeforeClass
	public void beforeClass() {

		
		if (osName.startsWith("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
		}
		else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}
		
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@Test
	public void User_01_Register() {
		//Click on Register button
		homePage = new UserHomePageObject(driver);
		homePage.clickToRegisterButton();
		basepage.clickToElement(driver,"//a[@class='ico-register']");
		
		
		registerPage = new UserRegisterPageObject(driver);
		//Select gender
		registerPage.clickToGenderMaleRadio();
		//basepage.clickToElement(driver, "//span[@class='male']");
		
		//Input first name & last name
		registerPage.inputToFirstNameTextbox("");
		registerPage.inputToLastNameTextbox("");
		//basepage.sendKeyToElement(driver, "//input[@id='FirstName']", "Luke");
		//basepage.sendKeyToElement(driver, "//input[@id='LastName']", "Phan");
		
		//Select birthday
		registerPage.selectDayDropdown("28");
		registerPage.selectMonthDropdown("January");
		registerPage.selectYearDropdown("1991");
		//basepage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "28");
		//basepage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "January");
		//basepage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1991");
		
		//Input email address
		registerPage.inputToEmailTextbox(emailAddress);
		//basepage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		
		//Input & confirm password
		registerPage.inputToCompanyTextbox("Marvel");
		registerPage.inputToPasswordTextbox("qqqq1111");
		registerPage.inputToConfirmPasswordTextbox("qqqq1111");
		//basepage.sendKeyToElement(driver, "//input[@id='Company']", "Marvel");
		//basepage.sendKeyToElement(driver, "//input[@id='Password']", "qqqq1111");
		basepage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "qqqq1111");
		//
		//Click REGISTER button
		registerPage.clickToRegisterButton();
		//basepage.clickToElement(driver, "//button[@id='register-button']");
		
		//Verify success message
		registerPage.getRegisterResultMessage();
		Assert.assertEquals(basepage.getElement(driver, "//div[@class='result']").getText(), "Your registration completed");
		
		//logout of current account
		registerPage.clickToLogoutLink();
		//basepage.clickToElement(driver, "//a[@class='ico-logout']");
		
		homePage = new UserHomePageObject(driver);
		Assert.assertEquals(homePage.getHomePageURL(), "https://demo.nopcommerce.com/");
	}
	
	@Test
	public void User_02_Login() {
		//click on login button
		homePage.clickToLoginLink();
		//basepage.clickToElement(driver, "//a[@class='ico-login']");
		
		//input Email address & password
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("qqqq1111");
		//basepage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		//basepage.sendKeyToElement(driver, "//input[@id='Password']", "qqqq1111");
		
		//submit login
		loginPage.clickToLoginButton();
		//basepage.clickToElement(driver, "//button[text()='Log in']");
		
		homePage = new UserHomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertEquals(basepage.getElement(driver, "//a[@class='ico-logout']").getText(), "Log out");
		
		homePage.clickToMyAccountLink();
		//basepage.clickToElement(driver, "//a[@class='ico-account']");
		customerInfoPage = new UserCustomerInfoPageObject(driver);
		
		Assert.assertTrue(customerInfoPage.isGenderMaleRadioSelected());
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxAttribute(""), "Luke");
		Assert.assertEquals(customerInfoPage.getLastNameTextboxAttribute(""), "Phan");
		Assert.assertEquals(customerInfoPage.getDayDropdownSelectedItem(), "28");
		Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedItem(), "January");
		Assert.assertEquals(customerInfoPage.getYearDropdownSelectedItem(), "1991");
		Assert.assertEquals(customerInfoPage.getEmailTextboxAttribute(""), emailAddress);
		Assert.assertEquals(customerInfoPage.getCompanyTextboxAttribute(""), "Marvel");
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public int generateRandomNumber() {
		Random email = new Random();
		return email.nextInt(9999);
	}
	
}
