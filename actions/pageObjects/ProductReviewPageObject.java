package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

import pageUIs.ProductReviewPageUI;

public class ProductReviewPageObject extends BasePage{
	WebDriver driver;
	
	public ProductReviewPageObject(WebDriver driver)	{
		this.driver = driver;
	}

	public RewardPageObject openRewardPage() {
		waitElementToBeClickable(driver, ProductReviewPageUI.REWARD_POINTS_LINK_SIDEBAR);
		clickToElement(driver,ProductReviewPageUI.REWARD_POINTS_LINK_SIDEBAR);
		return PageGeneratorManager.getRewardPage(driver);
}
}
