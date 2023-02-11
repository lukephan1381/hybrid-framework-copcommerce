package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserLoginPageObject getLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserCustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}
	
	public static UserOrdersPageObject getOrdersPage(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}
	
	public static UserRewardPageObject getRewardPage(WebDriver driver) {
		return new UserRewardPageObject(driver);
	}
	
	public static UserProductReviewPageObject getProductReviewPage(WebDriver driver) {
		return new UserProductReviewPageObject(driver);
	}
}
