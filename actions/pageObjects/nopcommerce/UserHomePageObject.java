package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.UserHomePageUI;

public class UserHomePageObject extends BasePage{
	
	WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Navigate to Register page")
	public UserRegisterPageObject clickToRegisterButton() {
		waitElementToBeClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		//return new RegisterPageObject(driver);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	public String getHomePageURL() {
		return getPageUrl(driver);
	}
	
	@Step("Navigate to Login Page")
	public UserLoginPageObject clickToLoginLink() {
		waitElementToBeClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	
	@Step("Verify My Account link is displayed")
	public boolean isMyAccountLinkDisplayed() {
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}
	
	@Step("Navigate to My Account link")
	public void clickToMyAccountLink() {
		waitElementToBeClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

}
