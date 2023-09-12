package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import pageUIs.nopcommerce.UserAddressPageUI;

public class UserAddressPageObject extends UserSideBarPageObject{

	WebDriver driver;
	
	public UserAddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitElementToBeClickable(driver, UserAddressPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, UserAddressPageUI.ADD_NEW_BUTTON);
	}

	public void inputToFirstNameTextbox(String firstname) {
		waitElementToBeVisible(driver,UserAddressPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.FIRST_NAME_TEXTBOX, firstname);
	}

	public void inputToLastNameTextbox(String lastname) {
		waitElementToBeVisible(driver,UserAddressPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.LAST_NAME_TEXTBOX, lastname);
	}

	public void inputToEmailTextbox(String email) {
		waitElementToBeVisible(driver,UserAddressPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToCompanyTextbox(String company) {
		waitElementToBeVisible(driver,UserAddressPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.COMPANY_TEXTBOX, company);
	}

	public void selectCountryDropdown(String country) {
		waitElementToBeClickable(driver, UserAddressPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, UserAddressPageUI.COUNTRY_DROPDOWN, country);
	}

	public void inputToCityTextbox(String city) {
		waitElementToBeVisible(driver,UserAddressPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.CITY_TEXTBOX, city);
	}

	public void inputToAddress1Textbox(String address1) {
		waitElementToBeVisible(driver,UserAddressPageUI.ADDRESS_1_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.ADDRESS_1_TEXTBOX, address1);
	}

	public void inputToAddress2Textbox(String address2) {
		waitElementToBeVisible(driver,UserAddressPageUI.ADDRESS_2_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.ADDRESS_2_TEXTBOX, address2);
	}

	public void inputToZipPostalCodeTextbox(String zipcode) {
		waitElementToBeVisible(driver,UserAddressPageUI.ZIP_CODE_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.ZIP_CODE_TEXTBOX, zipcode);
	}

	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitElementToBeVisible(driver,UserAddressPageUI.PHONE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void inputToFaxNumberTextbox(String faxNumber) {
		waitElementToBeVisible(driver,UserAddressPageUI.FAX_NUMBER_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void clickToSaveButton() {
		waitElementToBeClickable(driver, UserAddressPageUI.SAVE_BUTTON);
		clickToElement(driver, UserAddressPageUI.SAVE_BUTTON);
	}

	public String getAddressTitle() {
		waitElementToBeVisible(driver, UserAddressPageUI.ADDRESS_TITLE);
		return getElement(driver, UserAddressPageUI.ADDRESS_TITLE).getText();
	}

}
