package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class CustomerInfoPageObject {
	
	BasePage basepage = new BasePage();
	WebDriver driver;
	public void clickToRegisterButton() {
		basepage.clickToElement(driver,"//a[@class='ico-register']");
	}
	public boolean isGenderMaleRadioSelected() {
		// TODO Auto-generated method stub
		return false;
	}
	public String getFirstNameTextboxAttribute() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getLastNameTextboxAttribute() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getDayDropdownSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getMonthDropdownSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getYearDropdownSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEmailTextboxAttribute() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCompanyTextboxAttribute() {
		// TODO Auto-generated method stub
		return null;
	}

}
