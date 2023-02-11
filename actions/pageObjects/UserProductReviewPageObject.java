package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

import pageUIs.ProductReviewPageUI;

public class UserProductReviewPageObject extends BasePage{
	WebDriver driver;
	
	public UserProductReviewPageObject(WebDriver driver)	{
		this.driver = driver;
	}

	public UserRewardPageObject openRewardPage() {
		waitElementToBeClickable(driver, ProductReviewPageUI.REWARD_POINTS_LINK_SIDEBAR);
		clickToElement(driver,ProductReviewPageUI.REWARD_POINTS_LINK_SIDEBAR);
		return PageGeneratorManager.getRewardPage(driver);
}
}
