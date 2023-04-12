package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.UserSideBarPageUI;

public class UserSideBarPageObject extends BasePage{

	WebDriver driver;
	
	public UserSideBarPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserOrdersPageObject openOrderPage(WebDriver driver) {
		waitElementToBeClickable(driver, UserSideBarPageUI.DYNAMIC_ORDER_LINK_SIDEBAR);
		clickToElement(driver, UserSideBarPageUI.DYNAMIC_ORDER_LINK_SIDEBAR);
		return PageGeneratorManager.getUserOrdersPage(driver);
	}

	public UserProductReviewPageObject openProductReviewPage(WebDriver driver) {
		waitElementToBeClickable(driver, UserSideBarPageUI.DYNAMIC_PRODUCT_REVIEW_LINK_SIDEBAR);
		clickToElement(driver, UserSideBarPageUI.DYNAMIC_PRODUCT_REVIEW_LINK_SIDEBAR);
		return PageGeneratorManager.getUserProductReviewPage(driver);
	}

	public UserCustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
		waitElementToBeClickable(driver, UserSideBarPageUI.DYNAMIC_CUSTOMER_INFO_LINK_SIDEBAR);
		clickToElement(driver, UserSideBarPageUI.DYNAMIC_CUSTOMER_INFO_LINK_SIDEBAR);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}
	
	public UserRewardPageObject openRewardPage(WebDriver driver) {
		waitElementToBeClickable(driver, UserSideBarPageUI.DYNAMIC_REWARD_POINTS_LINK_SIDEBAR);
		clickToElement(driver, UserSideBarPageUI.DYNAMIC_REWARD_POINTS_LINK_SIDEBAR);
		return PageGeneratorManager.getUserRewardPage(driver);
	}
	
	public UserSideBarPageObject openSideBarPageByName(String pageName) {
//		block-account-navigation
//		Orders
//		Reward points
//		My product reviews
//		Customer info
		waitElementToBeClickable(driver, UserSideBarPageUI.DYNAMIC_ORDER_LINK_SIDEBAR, pageName);
		clickToElement(driver, UserSideBarPageUI.DYNAMIC_ORDER_LINK_SIDEBAR, pageName);
		
		if (pageName == "Orders") {
			return PageGeneratorManager.getUserOrdersPage(driver);
		}
		else if (pageName == "Reward points") {
			return PageGeneratorManager.getUserRewardPage(driver);
		}
		else if (pageName == "My product reviews") {
			return PageGeneratorManager.getUserProductReviewPage(driver);
		}
		else if (pageName == "Customer info") {
			return PageGeneratorManager.getUserCustomerInfoPage(driver);
		}
		return null;
	}
	
	public void openSideBarPageByPageName(String pageName) {
		waitElementToBeClickable(driver, UserSideBarPageUI.DYNAMIC_ORDER_LINK_SIDEBAR, pageName);
		clickToElement(driver, UserSideBarPageUI.DYNAMIC_ORDER_LINK_SIDEBAR, pageName);
	}
	
}
