package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}
	
	public static OrdersPageObject getOrdersPage(WebDriver driver) {
		return new OrdersPageObject(driver);
	}
	
	public static RewardPageObject getRewardPage(WebDriver driver) {
		return new RewardPageObject(driver);
	}
	
	public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
		return new ProductReviewPageObject(driver);
	}
}
