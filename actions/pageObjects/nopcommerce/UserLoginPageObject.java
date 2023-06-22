package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	
	WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Input to Email textbox with value {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitElementToBeVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}
	
	@Step("Input to Password textbox with value {0}")
	public void inputToPasswordTextbox(String password) {
		waitElementToBeVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	@Step("Click to Login button")
	public UserHomePageObject clickToLoginButton() {
		waitElementToBeClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
