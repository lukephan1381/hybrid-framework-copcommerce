package pageObjects;

import org.openqa.selenium.WebDriver;

public class UserRewardPageObject extends UserSideBarPageObject{
	WebDriver driver;

	public UserRewardPageObject(WebDriver driver)	{
		super(driver);
		this.driver = driver;
	}

//	public UserOrdersPageObject openOrderPage() {
//		waitElementToBeClickable(driver, UserOrdersPageUI.ORDER_LINK_SIDEBAR);
//		clickToElement(driver,UserOrdersPageUI.ORDER_LINK_SIDEBAR);
//		return PageGeneratorManager.getUserOrdersPage(driver);
//	}
}