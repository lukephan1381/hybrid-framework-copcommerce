package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import pageUIs.nopcommerce.UserProductReviewPageUI;

public class UserProductReviewPageObject extends UserSideBarPageObject{
	WebDriver driver;
	
	public UserProductReviewPageObject(WebDriver driver)	{
		super(driver);
		this.driver = driver;
	}

	public boolean isProductReviewDisplayedByProductName(String productName) {
		return isElementDisplayed(driver, UserProductReviewPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

//	public UserRewardPageObject openRewardPage() {
//		waitElementToBeClickable(driver, UserProductReviewPageUI.REWARD_POINTS_LINK_SIDEBAR);
//		clickToElement(driver,UserProductReviewPageUI.REWARD_POINTS_LINK_SIDEBAR);
//		return PageGeneratorManager.getUserRewardPage(driver);
//	}
}
