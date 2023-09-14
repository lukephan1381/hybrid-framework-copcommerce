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
import pageObjects.nopcommerce.UserAddressPageObject;
import pageObjects.nopcommerce.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.UserHeaderPageObject;
import pageObjects.nopcommerce.UserHomePageObject;
import pageObjects.nopcommerce.UserLoginPageObject;
import pageObjects.nopcommerce.UserPasswordPageObject;

public class User_003_My_Account extends BaseTest{
	@Parameters({"browser","userURL"})
	@BeforeClass
	public void beforeClass(String browser, String userURL){
		driver = getBrowserDriver(browser, userURL);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = Common_01_Register.emailAddress;
		currentPassword = Common_01_Register.password;
		newPassword = "qqqqqqqq";
		
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(currentPassword);
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		homePage.clickToMyAccountLink();
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		
	}
	
	@Test
	public void MyAccount_001_Update_Info() {
		customerInfoPage.clickToGenderFemaleRadio();
		customerInfoPage.inputToFirstNameTextbox("Automation");
		customerInfoPage.inputToLastNameTextbox("FC");
		customerInfoPage.selectDayDropdown("1");
		customerInfoPage.selectMonthDropdown("January");
		customerInfoPage.selectYearDropdown("1991");
		customerInfoPage.inputToCompanyTextbox("Automation FC");
	}
	
	@Test
	public void MyAccount_002_Add_Address() {
		customerInfoPage.openSideBarPageByPageName("Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		addressPage.clickToAddNewButton();
		addressPage.inputToFirstNameTextbox("Automation");
		addressPage.inputToLastNameTextbox("FC");
		addressPage.inputToEmailTextbox("lukephan@auto.com");
		addressPage.inputToCompanyTextbox("Automation FC");
		addressPage.selectCountryDropdown("Viet Nam");
		addressPage.inputToCityTextbox("Da Nang");
		addressPage.inputToAddress1Textbox("Hello Da Nang");
		addressPage.inputToAddress2Textbox("Hello Pleiku");
		addressPage.inputToZipPostalCodeTextbox("550000");
		addressPage.inputToPhoneNumberTextbox("0123456789");
		addressPage.inputToFaxNumberTextbox("9876543210");
		addressPage.clickToSaveButton();
		Assert.assertEquals(addressPage.getAddressTitle(), "Automation FC");
	}
	
	@Test
	public void MyAccount_003_Change_Password() {
		customerInfoPage.openSideBarPageByPageName("Change password");
		passwordPage = PageGeneratorManager.getUserPasswordPage(driver);
		passwordPage.inputToOldPasswordTextbox(currentPassword);
		passwordPage.inputToNewPasswordTextbox(newPassword);
		passwordPage.inputToConfirmPasswordTextbox(newPassword);
		passwordPage.clickToChangePasswordButton();
		////div[@class='bar-notification success']/p
		Assert.assertEquals(passwordPage.getChangePasswordSuccessNotif(),"Password was changed");
		
		passwordPage.clickToCloseNotificationButton();
		homePage = passwordPage.clickToLogoutLink();

		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(currentPassword);
		loginPage.clickToButtonByText(driver, "Log in");
		Assert.assertEquals(loginPage.getErrorMessageIncorrectPassword(), "Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");
		
		loginPage.inputToPasswordTextbox(newPassword);
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void MyAccount_004_Review_Product() {
		headerPage = PageGeneratorManager.getUserHeaderPageObject(driver);
		headerPage.openHeaderPageByPageName("Computers ");
	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
	
	WebDriver driver;
	String emailAddress,currentPassword,newPassword;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfoPage;
	UserAddressPageObject addressPage;
	UserPasswordPageObject passwordPage;
	UserHeaderPageObject headerPage;
}
