package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.UserSideBarPageUI;
import commons.BasePage;

public class UserSideBarPageObject extends BasePage{

	WebDriver driver;
	
	public UserSideBarPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserOrdersPageObject openOrderPage(WebDriver driver) {
		waitElementToBeClickable(driver, UserSideBarPageUI.ORDER_LINK_SIDEBAR);
		clickToElement(driver, UserSideBarPageUI.ORDER_LINK_SIDEBAR);
		return PageGeneratorManager.getUserOrdersPage(driver);
	}

	public UserProductReviewPageObject openProductReviewPage(WebDriver driver) {
		waitElementToBeClickable(driver, UserSideBarPageUI.PRODUCT_REVIEW_LINK_SIDEBAR);
		clickToElement(driver, UserSideBarPageUI.PRODUCT_REVIEW_LINK_SIDEBAR);
		return PageGeneratorManager.getUserProductReviewPage(driver);
	}

	public UserCustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
		waitElementToBeClickable(driver, UserSideBarPageUI.CUSTOMER_INFO_LINK_SIDEBAR);
		clickToElement(driver, UserSideBarPageUI.CUSTOMER_INFO_LINK_SIDEBAR);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}
	
	public UserRewardPageObject openRewardPage(WebDriver driver) {
		waitElementToBeClickable(driver, UserSideBarPageUI.REWARD_POINTS_LINK_SIDEBAR);
		clickToElement(driver, UserSideBarPageUI.REWARD_POINTS_LINK_SIDEBAR);
		return PageGeneratorManager.getUserRewardPage(driver);
	}
	
}
