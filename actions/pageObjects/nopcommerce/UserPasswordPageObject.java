package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.UserPasswordPageUI;

public class UserPasswordPageObject extends BasePage {
	WebDriver driver;
	
	public UserPasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToOldPasswordTextbox(String oldPassword) {
		waitElementToBeVisible(driver, UserPasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserPasswordPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitElementToBeVisible(driver, UserPasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserPasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitElementToBeVisible(driver, UserPasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserPasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickToChangePasswordButton() {
		waitElementToBeClickable(driver, UserPasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserPasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public String getChangePasswordSuccessNotif() {
		waitElementToBeVisible(driver, UserPasswordPageUI.SUCCESS_NOTIFICATION);
		return getElement(driver, UserPasswordPageUI.SUCCESS_NOTIFICATION).getText();
	}

	public void clickToCloseNotificationButton() {
		waitElementToBeClickable(driver, UserPasswordPageUI.CLOSE_NOTIFICATION_BUTTON);
		clickToElement(driver, UserPasswordPageUI.CLOSE_NOTIFICATION_BUTTON);
	}

	public UserHomePageObject clickToLogoutLink() {
		waitElementToBeClickable(driver, UserPasswordPageUI.LOGOUT_LINK);
		clickToElement(driver, UserPasswordPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}
}
