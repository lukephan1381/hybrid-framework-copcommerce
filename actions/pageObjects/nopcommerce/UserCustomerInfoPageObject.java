package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageUIs.nopcommerce.UserCustomerInfoPageUI;
import pageUIs.nopcommerce.UserRegisterPageUI;

public class UserCustomerInfoPageObject extends UserSideBarPageObject{

	WebDriver driver;
	
	public UserCustomerInfoPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void clickToSaveButton() {
		waitElementToBeClickable(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver,UserCustomerInfoPageUI.SAVE_BUTTON);
	}
	
	public boolean isGenderMaleRadioSelected() {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
	}
	
	public boolean isGenderFemaleRadioSelected() {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
		return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
	}
	
	public String getFirstNameTextboxAttribute(String attributeName) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX, attributeName);
	}
	
	public String getLastNameTextboxAttribute(String attributeName) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX, attributeName);
	}
	
	public String getDayDropdownSelectedItem() {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
		return getSelectedItemInDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
	}
	
	public String getMonthDropdownSelectedItem() {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
		return getSelectedItemInDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
	}
	
	public String getYearDropdownSelectedItem() {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
		return getSelectedItemInDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
	}
	
	public String getEmailTextboxAttribute(String attributeName) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, attributeName);
	}
	
	public String getCompanyTextboxAttribute(String attributeName) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, attributeName);
	}
//	public UserOrdersPageObject openOrderPage() {
//		waitElementToBeClickable(driver, UserCustomerInfoPageUI.ORDER_LINK_SIDEBAR);
//		clickToElement(driver, UserCustomerInfoPageUI.ORDER_LINK_SIDEBAR);
//		return PageGeneratorManager.getUserOrdersPage(driver);
//	}
	
	@Step("Select Male gender")
	public void clickToGenderMaleRadio() {
		waitElementToBeClickable(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
		checkOnCheckboxOrRadio(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
	}
	
	@Step("Select Female gender")
	public void clickToGenderFemaleRadio() {
		waitElementToBeClickable(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
		checkOnCheckboxOrRadio(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
	}
	
	@Step("Input to Firstname textbox with value {0}")
	public void inputToFirstNameTextbox(String firstName) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX, firstName);
	}
	
	@Step("Input to Lastname textbox with value {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX, lastName);
	}

	@Step("Select Day dropdown with value {0}")
	public void selectDayDropdown(String textValue) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN, textValue);
	}
	
	@Step("Select Month dropdown with value {0}")
	public void selectMonthDropdown(String textValue) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN, textValue);
	}

	@Step("Select Year dropdown with value {0}")	
	public void selectYearDropdown(String textValue) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN, textValue);
	}

	@Step("Input to Email Address textbox with value {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	@Step("Input to Company textbox with value {0}")
	public void inputToCompanyTextbox(String companyName) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, companyName);
	}

}
