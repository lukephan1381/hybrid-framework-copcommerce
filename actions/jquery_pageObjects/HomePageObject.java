package jquery_pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import jquery_pageUIs.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByPageNumber(String pageNumber) {
		waitElementToBeClickable(driver, HomePageUI.DYNAMIC_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.DYNAMIC_PAGE_BY_NUMBER, pageNumber);
	}
}
