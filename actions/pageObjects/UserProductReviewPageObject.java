package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

import pageUIs.UserProductReviewPageUI;

public class UserProductReviewPageObject extends BasePage{
	WebDriver driver;
	
	public UserProductReviewPageObject(WebDriver driver)	{
		this.driver = driver;
	}

	public UserRewardPageObject openRewardPage() {
		waitElementToBeClickable(driver, UserProductReviewPageUI.REWARD_POINTS_LINK_SIDEBAR);
		clickToElement(driver,UserProductReviewPageUI.REWARD_POINTS_LINK_SIDEBAR);
		return PageGeneratorManager.getUserRewardPage(driver);
}
}
