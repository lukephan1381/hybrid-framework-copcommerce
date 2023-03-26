package jquery_pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	public void inputToHeaderTextboxByLabel(String label, String keyword) {
		waitElementToBeVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_LABEL, label);
		sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_LABEL, keyword, label);
		sendKeyboardToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_LABEL, Keys.ENTER, label);
	}

	public boolean isPageNumberActive(String pageNumber) {
		waitElementToBeVisible(driver, HomePageUI.DYNAMIC_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver,HomePageUI.DYNAMIC_PAGE_ACTIVE_BY_NUMBER ,pageNumber);
	}

	public List<String> getRowValuesAtAllPage() {
		int totalPage = getElementsSize(driver, HomePageUI.TOTAL_PAGE);
		System.out.println("Total size: " + totalPage);
		
		List<String> allRowValuesAllPages = new ArrayList<String>();
		
		for (int i = 1; i <= totalPage; i++) {
			clickToElement(driver, HomePageUI.DYNAMIC_PAGE_BY_INDEX, String.valueOf(i));
			//sleepInSecond(1);
			
			List<WebElement> allRowElementEachPage = getElements(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValuesAllPages.add(eachRow.getText());
				//System.out.println("-------------------------------------");
				//System.out.println(eachRow.getText());
			}
		}
		
		/*
		 * for (String value : allRowValuesAllPages) {
		 * System.out.println("-------------------------------------");
		 * System.out.println(value); }
		 */
		return allRowValuesAllPages;
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitElementToBeVisible(driver, HomePageUI.TEXTBOX_BY_ROW_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		sendKeyToElement(driver, HomePageUI.TEXTBOX_BY_ROW_AND_COLUMN_INDEX, value, rowNumber, String.valueOf(columnIndex));	
	}
	
	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitElementToBeVisible(driver, HomePageUI.DROPDOWN_BY_ROW_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDropdown(driver, HomePageUI.DROPDOWN_BY_ROW_AND_COLUMN_INDEX, value, rowNumber, String.valueOf(columnIndex));
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitElementToBeVisible(driver, HomePageUI.CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		checkOnCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
	}
	
	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitElementToBeVisible(driver, HomePageUI.CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToCheckbox(driver, HomePageUI.CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToLoadButton() {
		waitElementToBeClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);
		
	}

	public void clickToIconByRowNumber(String rowNumber, String iconTitle) {
		waitElementToBeClickable(driver, HomePageUI.ICON_BY_ROW_NUMBER,rowNumber, iconTitle);
		clickToElement(driver, HomePageUI.ICON_BY_ROW_NUMBER,rowNumber, iconTitle);
	}
	
	
}
