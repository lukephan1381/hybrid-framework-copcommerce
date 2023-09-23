package pageObjects.nopcommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopcommerce.UserSearchPageUI;

public class UserSearchPageObject extends BasePage {
	WebDriver driver;
	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToSearchTextbox(String searchKey) {
		waitElementToBeVisible(driver, UserSearchPageUI.SEARCH_TEXTBOX);
		sendKeyToElement(driver, UserSearchPageUI.SEARCH_TEXTBOX, searchKey);
		
	}
	public void clickToSearchbutton() {
		waitElementToBeClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}
	public String getSearchEmptyErrorMessage() {
		waitElementToBeVisible(driver, UserSearchPageUI.EMPTY_KEYWORD_ERROR_MESSAGE);
		return getElement(driver, UserSearchPageUI.EMPTY_KEYWORD_ERROR_MESSAGE).getText();
	}
	public String getSearchNoProductErrorMessage() {
		waitElementToBeVisible(driver, UserSearchPageUI.NO_PRODUCT_ERROR_MESSAGE);
		return getElement(driver, UserSearchPageUI.NO_PRODUCT_ERROR_MESSAGE).getText();
	}
	public List<WebElement> getListOfResults() {
		waitElementToBeVisible(driver, UserSearchPageUI.PRODUCTS_LIST);
		return getElements(driver, UserSearchPageUI.PRODUCTS_LIST);
	}
	public void checkOnAdvancedSearchCheckbox() {
		waitElementToBeClickable(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		checkOnCheckboxOrRadio(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
	}
	public void selectCategoryByText(String category) {
		waitElementToBeClickable(driver, UserSearchPageUI.CATEGORY_DROPDOWN);
		selectItemInDropdown(driver, UserSearchPageUI.CATEGORY_DROPDOWN, category);
	}
	public void checkOnSearchSubCategoryCheckbox() {
		waitElementToBeClickable(driver, UserSearchPageUI.SUB_CATEGORY_CHECKBOX);
		checkOnCheckboxOrRadio(driver, UserSearchPageUI.SUB_CATEGORY_CHECKBOX);
	}
	public void selectManufacturerByText(String manufacturer) {
		waitElementToBeClickable(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDropdown(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN, manufacturer);
	}
}
