package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.OrdersPageUI;

public class RewardPageObject extends BasePage{
	WebDriver driver;

	public RewardPageObject(WebDriver driver)	{
		this.driver = driver;
	}

	public OrdersPageObject openOrderPage() {
		waitElementToBeClickable(driver, OrdersPageUI.ORDER_LINK_SIDEBAR);
		clickToElement(driver,OrdersPageUI.ORDER_LINK_SIDEBAR);
		return PageGeneratorManager.getOrdersPage(driver);
	}
}
