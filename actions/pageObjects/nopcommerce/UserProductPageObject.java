package pageObjects.nopcommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopcommerce.UserProductPageUI;

public class UserProductPageObject extends BasePage {
	WebDriver driver;
	
	public UserProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToSubCategoryByName(String subCategory) {
		waitElementToBeClickable(driver, UserProductPageUI.DYNAMIC_SUB_CATEGORY, subCategory);
		clickToElement(driver, UserProductPageUI.DYNAMIC_SUB_CATEGORY, subCategory);
	}

	public void clickToProductByName(String productName) {
		waitElementToBeClickable(driver, UserProductPageUI.DYNAMIC_PRODUCT_NAME, productName);
		clickToElement(driver, UserProductPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

	public void clickToAddYourReviewLink() {
		waitElementToBeClickable(driver, UserProductPageUI.ADD_REVIEW_LINK);
		clickToElement(driver, UserProductPageUI.ADD_REVIEW_LINK);
	}
	
	public void selectSortTypeByText(String string) {
		// TODO Auto-generated method stub
		
	}
	
	public List<WebElement> getListOfProducts(){
		waitElementToBeVisible(driver, UserProductPageUI.PRODUCTS_ITEM_LIST);
		return getElements(driver, UserProductPageUI.PRODUCTS_ITEM_LIST);
	}

}
