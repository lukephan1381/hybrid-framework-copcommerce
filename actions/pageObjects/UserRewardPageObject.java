package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.UserOrdersPageUI;

public class UserRewardPageObject extends BasePage{
	WebDriver driver;

	public UserRewardPageObject(WebDriver driver)	{
		this.driver = driver;
	}

	public UserOrdersPageObject openOrderPage() {
		waitElementToBeClickable(driver, UserOrdersPageUI.ORDER_LINK_SIDEBAR);
		clickToElement(driver,UserOrdersPageUI.ORDER_LINK_SIDEBAR);
		return PageGeneratorManager.getUserOrdersPage(driver);
	}
}