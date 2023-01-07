package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.OrdersPageUI;

public class OrdersPageObject extends BasePage {
	WebDriver driver;
	
	public OrdersPageObject(WebDriver driver)	{
		this.driver = driver;
	}

	public ProductReviewPageObject openProductReviewPage() {
		waitElementToBeClickable(driver, OrdersPageUI.PRODUCT_REVIEW_LINK_SIDEBAR);
		clickToElement(driver, OrdersPageUI.PRODUCT_REVIEW_LINK_SIDEBAR);
		return PageGeneratorManager.getProductReviewPage(driver);
	}

	public RewardPageObject openRewardPage() {
		waitElementToBeClickable(driver, OrdersPageUI.REWARD_POINTS_LINK_SIDEBAR);
		clickToElement(driver, OrdersPageUI.REWARD_POINTS_LINK_SIDEBAR);
		return PageGeneratorManager.getRewardPage(driver);
	}
}
