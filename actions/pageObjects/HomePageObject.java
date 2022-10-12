package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class HomePageObject {
	
	BasePage basepage = new BasePage();
	WebDriver driver;
	public void clickToRegisterButton() {
		basepage.clickToElement(driver,"//a[@class='ico-register']");
	}
	public String getHomePageURL() {
		// TODO Auto-generated method stub
		return null;
	}
	public void clickToLoginLink() {
		// TODO Auto-generated method stub
		
	}
	public boolean isMyAccountLinkDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	public void clickToMyAccountLink() {
		// TODO Auto-generated method stub
		
	}

}
