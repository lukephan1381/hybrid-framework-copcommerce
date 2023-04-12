package pageObjects.facebook;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.facebook.LoginPageUIs;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitElementToBeClickable(driver, LoginPageUIs.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUIs.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitElementToBeVisible(driver, LoginPageUIs.SIGN_UP_FORM_EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUIs.SIGN_UP_FORM_EMAIL_ADDRESS_TEXTBOX);
	}

	public boolean isConfirmEmailAddressTextboxDisplayed() {
		return isElementDisplayed(driver, LoginPageUIs.SIGN_UP_FORM_COMFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void enterToEmailAddressTextbox(String emailAddress) {
		waitElementToBeVisible(driver, LoginPageUIs.SIGN_UP_FORM_EMAIL_ADDRESS_TEXTBOX);
		sendKeyToElement(driver, LoginPageUIs.SIGN_UP_FORM_EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	
}
