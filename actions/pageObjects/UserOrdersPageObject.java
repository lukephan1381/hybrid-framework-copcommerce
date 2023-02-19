package pageObjects;

import org.openqa.selenium.WebDriver;

public class UserOrdersPageObject extends UserSideBarPageObject {
	WebDriver driver;
	
	public UserOrdersPageObject(WebDriver driver)	{
		super(driver);
		this.driver = driver;
	}

//	public UserProductReviewPageObject openProductReviewPage() {
//		waitElementToBeClickable(driver, UserOrdersPageUI.PRODUCT_REVIEW_LINK_SIDEBAR);
//		clickToElement(driver, UserOrdersPageUI.PRODUCT_REVIEW_LINK_SIDEBAR);
//		return PageGeneratorManager.getUserProductReviewPage(driver);
//	}
//
//	public UserRewardPageObject openRewardPage() {
//		waitElementToBeClickable(driver, UserOrdersPageUI.REWARD_POINTS_LINK_SIDEBAR);
//		clickToElement(driver, UserOrdersPageUI.REWARD_POINTS_LINK_SIDEBAR);
//		return PageGeneratorManager.getUserRewardPage(driver);
//	}
}
