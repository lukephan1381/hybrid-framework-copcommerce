package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.OrdersPageUI;

public class UserOrdersPageObject extends BasePage {
	WebDriver driver;
	
	public UserOrdersPageObject(WebDriver driver)	{
		this.driver = driver;
	}

	public UserProductReviewPageObject openProductReviewPage() {
		waitElementToBeClickable(driver, OrdersPageUI.PRODUCT_REVIEW_LINK_SIDEBAR);
		clickToElement(driver, OrdersPageUI.PRODUCT_REVIEW_LINK_SIDEBAR);
		return PageGeneratorManager.getProductReviewPage(driver);
	}

	public UserRewardPageObject openRewardPage() {
		waitElementToBeClickable(driver, OrdersPageUI.REWARD_POINTS_LINK_SIDEBAR);
		clickToElement(driver, OrdersPageUI.REWARD_POINTS_LINK_SIDEBAR);
		return PageGeneratorManager.getRewardPage(driver);
	}
}
