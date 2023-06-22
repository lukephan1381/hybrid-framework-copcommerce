package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	
	WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Select Male gender")
	public void clickToGenderMaleRadio() {
		waitElementToBeClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
		checkOnCheckboxOrRadio(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
	}
	
	@Step("Select Female gender")
	public void clickToGenderFemaleRadio() {
		waitElementToBeClickable(driver, UserRegisterPageUI.GENDER_FEMALE_RADIO);
		checkOnCheckboxOrRadio(driver, UserRegisterPageUI.GENDER_FEMALE_RADIO);
	}
	
	@Step("Input to Firstname textbox with value {0}")
	public void inputToFirstNameTextbox(String firstName) {
		waitElementToBeVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}
	
	@Step("Input to Lastname textbox with value {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitElementToBeVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	@Step("Select Day dropdown with value {0}")
	public void selectDayDropdown(String textValue) {
		waitElementToBeVisible(driver, UserRegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN, textValue);
	}
	
	@Step("Select Month dropdown with value {0}")
	public void selectMonthDropdown(String textValue) {
		waitElementToBeVisible(driver, UserRegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, textValue);
	}

	@Step("Select Year dropdown with value {0}")	
	public void selectYearDropdown(String textValue) {
		waitElementToBeVisible(driver, UserRegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, textValue);
	}

	@Step("Input to Email Address textbox with value {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitElementToBeVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	@Step("Input to Company textbox with value {0}")
	public void inputToCompanyTextbox(String companyName) {
		waitElementToBeVisible(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, companyName);
	}

	@Step("Input to Password textbox with value {0}")
	public void inputToPasswordTextbox(String password) {
		waitElementToBeVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Input to Confirm Password textbox with value {0}")
	public void inputToConfirmPasswordTextbox(String passwordConfirm) {
		waitElementToBeVisible(driver, UserRegisterPageUI.PASSWORD_CONFIRM_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_CONFIRM_TEXTBOX, passwordConfirm);
	}

	@Step("Click Register button")
	public void clickToRegisterButton() {
		waitElementToBeClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	@Step("Get register result message")
	public String getRegisterResultMessage() {
		waitElementToBeVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElement(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE).getText();
	}

	@Step("Click Logout Link")
	public UserHomePageObject clickToLogoutLink() {
		waitElementToBeVisible(driver, UserRegisterPageUI.LOGIN_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	@Step("Click Continue button")
	public UserHomePageObject clickToContinueButton() {
		waitElementToBeVisible(driver, UserRegisterPageUI.CONTINUE_BUTTON);
		clickToElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
