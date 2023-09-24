package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}
	
	public static UserOrdersPageObject getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}
	
	public static UserRewardPageObject getUserRewardPage(WebDriver driver) {
		return new UserRewardPageObject(driver);
	}
	
	public static UserProductReviewPageObject getUserProductReviewPage(WebDriver driver) {
		return new UserProductReviewPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new AdminDashboardPageObject(driver);
	}

	public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserAddressPageObject(driver);
	}

	public static UserPasswordPageObject getUserPasswordPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserPasswordPageObject(driver);
	}

	public static UserReviewProductPageObject getUserReviewProductPageObject(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserReviewProductPageObject(driver);
	}

	public static UserSearchPageObject getUserSearchPageObject(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserSearchPageObject(driver);
	}

	public static UserProductPageObject getUserProductPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserProductPageObject(driver);
	}
}
