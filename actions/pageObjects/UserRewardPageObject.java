package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.OrdersPageUI;

public class UserRewardPageObject extends BasePage{
	WebDriver driver;

	public UserRewardPageObject(WebDriver driver)	{
		this.driver = driver;
	}

	public UserOrdersPageObject openOrderPage() {
		waitElementToBeClickable(driver, OrdersPageUI.ORDER_LINK_SIDEBAR);
		clickToElement(driver,OrdersPageUI.ORDER_LINK_SIDEBAR);
		return PageGeneratorManager.getOrdersPage(driver);
	}
}
