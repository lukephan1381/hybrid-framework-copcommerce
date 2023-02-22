package nopcommerce_pageObjects;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import nopcommerce_pageUIs.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	
	WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderMaleRadio() {
		waitElementToBeClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
		checkOnCheckboxOrRadio(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
	}
	
	public void clickToGenderFemaleRadio() {
		waitElementToBeClickable(driver, UserRegisterPageUI.GENDER_FEMALE_RADIO);
		checkOnCheckboxOrRadio(driver, UserRegisterPageUI.GENDER_FEMALE_RADIO);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitElementToBeVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitElementToBeVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void selectDayDropdown(String textValue) {
		waitElementToBeVisible(driver, UserRegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN, textValue);
	}

	public void selectMonthDropdown(String textValue) {
		waitElementToBeVisible(driver, UserRegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, textValue);
	}

	public void selectYearDropdown(String textValue) {
		waitElementToBeVisible(driver, UserRegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, textValue);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitElementToBeVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToCompanyTextbox(String companyName) {
		waitElementToBeVisible(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, companyName);
	}

	public void inputToPasswordTextbox(String password) {
		waitElementToBeVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String passwordConfirm) {
		waitElementToBeVisible(driver, UserRegisterPageUI.PASSWORD_CONFIRM_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_CONFIRM_TEXTBOX, passwordConfirm);
	}

	public void clickToRegisterButton() {
		waitElementToBeClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterResultMessage() {
		waitElementToBeVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElement(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE).getText();
	}

	public UserHomePageObject clickToLogoutLink() {
		waitElementToBeVisible(driver, UserRegisterPageUI.LOGIN_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public UserHomePageObject clickToContinueButton() {
		waitElementToBeVisible(driver, UserRegisterPageUI.CONTINUE_BUTTON);
		clickToElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
