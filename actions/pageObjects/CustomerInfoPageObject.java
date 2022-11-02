package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;
import commons.BasePage;

public class CustomerInfoPageObject extends BasePage{

	WebDriver driver;
	
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToSaveButton() {
		waitElementToBeClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver,CustomerInfoPageUI.SAVE_BUTTON);
	}
	
	public boolean isGenderMaleRadioSelected() {
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
	}
	
	public boolean isGenderFemaleRadioSelected() {
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO);
	}
	
	public String getFirstNameTextboxAttribute(String attributeName) {
		return getElementAttribute(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, attributeName);
	}
	
	public String getLastNameTextboxAttribute(String attributeName) {
		return getElementAttribute(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, attributeName);
	}
	
	public String getDayDropdownSelectedItem() {
		return getSelectedItemInDropdown(driver, CustomerInfoPageUI.DAY_DROPDOWN);
	}
	
	public String getMonthDropdownSelectedItem() {
		return getSelectedItemInDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
	}
	
	public String getYearDropdownSelectedItem() {
		return getSelectedItemInDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
	}
	
	public String getEmailTextboxAttribute(String attributeName) {
		return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, attributeName);
	}
	
	public String getCompanyTextboxAttribute(String attributeName) {
		return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, attributeName);
	}

}
