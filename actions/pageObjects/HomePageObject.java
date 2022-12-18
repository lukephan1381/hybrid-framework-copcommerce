package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{
	
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public RegisterPageObject clickToRegisterButton() {
		waitElementToBeClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		//return new RegisterPageObject(driver);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	public String getHomePageURL() {
		return getPageUrl(driver);
	}
	public LoginPageObject clickToLoginLink() {
		waitElementToBeClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}
	public boolean isMyAccountLinkDisplayed() {
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}
	public void clickToMyAccountLink() {
		waitElementToBeClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

}
