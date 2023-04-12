package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.nopcommerce.UserHomePageUI;

public class UserHomePageObject extends BasePage{
	
	WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserRegisterPageObject clickToRegisterButton() {
		waitElementToBeClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		//return new RegisterPageObject(driver);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	public String getHomePageURL() {
		return getPageUrl(driver);
	}
	public UserLoginPageObject clickToLoginLink() {
		waitElementToBeClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	public boolean isMyAccountLinkDisplayed() {
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}
	public void clickToMyAccountLink() {
		waitElementToBeClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

}
