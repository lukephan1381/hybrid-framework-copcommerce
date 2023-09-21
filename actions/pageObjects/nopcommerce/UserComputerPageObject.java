package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import pageUIs.nopcommerce.UserComputerPageUI;

public class UserComputerPageObject extends UserHeaderPageObject{
	WebDriver driver;
	
	public UserComputerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToSubCategoryByName(String subCategory) {
		waitElementToBeClickable(driver, UserComputerPageUI.DYNAMIC_SUB_CATEGORY, subCategory);
		clickToElement(driver, UserComputerPageUI.DYNAMIC_SUB_CATEGORY, subCategory);
	}

	public void clickToProductByName(String productName) {
		waitElementToBeClickable(driver, UserComputerPageUI.DYNAMIC_PRODUCT_NAME, productName);
		clickToElement(driver, UserComputerPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

	public void clickToAddYourReviewLink() {
		waitElementToBeClickable(driver, UserComputerPageUI.ADD_REVIEW_LINK);
		clickToElement(driver, UserComputerPageUI.ADD_REVIEW_LINK);
	}
}
