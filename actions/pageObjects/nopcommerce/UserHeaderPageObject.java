package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.UserComputerPageUI;
import pageUIs.nopcommerce.UserHeaderPageUI;

public class UserHeaderPageObject extends BasePage{
	WebDriver driver;
	
	public UserHeaderPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openHeaderPageByPageName(String pageName) {
		waitElementToBeClickable(driver, UserHeaderPageUI.DYNAMIC_LINK_HEADER, pageName);
		clickToElement(driver, UserHeaderPageUI.DYNAMIC_LINK_HEADER, pageName);
	}
	
	public UserComputerPageObject openComputerPage(WebDriver driver) {
		waitElementToBeClickable(driver, UserComputerPageUI.DESKTOPS_PAGE_LINK);
		clickToElement(driver, UserComputerPageUI.DESKTOPS_PAGE_LINK);
		return PageGeneratorManager.getUserComputerPageObject(driver);
	}
}
