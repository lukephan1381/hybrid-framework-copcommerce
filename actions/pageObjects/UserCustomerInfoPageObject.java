package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.UserCustomerInfoPageUI;
import commons.BasePage;

public class UserCustomerInfoPageObject extends BasePage{

	WebDriver driver;
	
	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToSaveButton() {
		waitElementToBeClickable(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver,UserCustomerInfoPageUI.SAVE_BUTTON);
	}
	
	public boolean isGenderMaleRadioSelected() {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
	}
	
	public boolean isGenderFemaleRadioSelected() {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
		return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
	}
	
	public String getFirstNameTextboxAttribute(String attributeName) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX, attributeName);
	}
	
	public String getLastNameTextboxAttribute(String attributeName) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX, attributeName);
	}
	
	public String getDayDropdownSelectedItem() {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
		return getSelectedItemInDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
	}
	
	public String getMonthDropdownSelectedItem() {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
		return getSelectedItemInDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
	}
	
	public String getYearDropdownSelectedItem() {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
		return getSelectedItemInDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
	}
	
	public String getEmailTextboxAttribute(String attributeName) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, attributeName);
	}
	
	public String getCompanyTextboxAttribute(String attributeName) {
		waitElementToBeVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, attributeName);
	}

	public UserOrdersPageObject openOrderPage() {
		waitElementToBeClickable(driver, UserCustomerInfoPageUI.ORDER_LINK_SIDEBAR);
		clickToElement(driver, UserCustomerInfoPageUI.ORDER_LINK_SIDEBAR);
		return PageGeneratorManager.getUserOrdersPage(driver);
	}

}
