package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	
	WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderMaleRadio() {
		waitElementToBeClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		checkOnCheckboxOrRadio(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}
	
	public void clickToGenderFemaleRadio() {
		waitElementToBeClickable(driver, RegisterPageUI.GENDER_FEMALE_RADIO);
		checkOnCheckboxOrRadio(driver, RegisterPageUI.GENDER_FEMALE_RADIO);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitElementToBeVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitElementToBeVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void selectDayDropdown(String textValue) {
		waitElementToBeVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.DAY_DROPDOWN, textValue);
	}

	public void selectMonthDropdown(String textValue) {
		waitElementToBeVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, textValue);
	}

	public void selectYearDropdown(String textValue) {
		waitElementToBeVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, textValue);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitElementToBeVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToCompanyTextbox(String companyName) {
		waitElementToBeVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, companyName);
	}

	public void inputToPasswordTextbox(String password) {
		waitElementToBeVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String passwordConfirm) {
		waitElementToBeVisible(driver, RegisterPageUI.PASSWORD_CONFIRM_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_CONFIRM_TEXTBOX, passwordConfirm);
	}

	public void clickToRegisterButton() {
		waitElementToBeClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterResultMessage() {
		waitElementToBeVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE).getText();
	}

	public UserHomePageObject clickToLogoutLink() {
		waitElementToBeVisible(driver, RegisterPageUI.LOGIN_LINK);
		clickToElement(driver, RegisterPageUI.LOGIN_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public UserHomePageObject clickToContinueButton() {
		waitElementToBeVisible(driver, RegisterPageUI.CONTINUE_BUTTON);
		clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
