package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.UserReviewProductPageUI;

public class UserReviewProductPageObject extends BasePage {
	WebDriver driver;
	
	public UserReviewProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitElementToBeVisible(driver, UserReviewProductPageUI.REVIEW_TITLE_TEXTBOX);
		sendKeyToElement(driver, UserReviewProductPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	public void inputToReviewBodyTextbox(String reviewBody) {
		waitElementToBeVisible(driver, UserReviewProductPageUI.REVIEW_BODY_TEXTAREA);
		sendKeyToElement(driver, UserReviewProductPageUI.REVIEW_BODY_TEXTAREA, reviewBody);
	}

	public void clickToRatingRadioByValue(String ratingValue) {
		waitElementToBeClickable(driver, UserReviewProductPageUI.DYNAMIC_RATING_RADIO, ratingValue);
		checkOnCheckboxOrRadio(driver, UserReviewProductPageUI.DYNAMIC_RATING_RADIO, ratingValue);
	}

	public void clickToSubmitReviewButton() {
		waitElementToBeClickable(driver, UserReviewProductPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, UserReviewProductPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public void getAddReviewResultMessage() {
		waitElementToBeVisible(driver, UserReviewProductPageUI.ADD_REVIEW_RESULT_MESSAGE);
		getElement(driver, UserReviewProductPageUI.ADD_REVIEW_RESULT_MESSAGE).getText();
	}

	public void clickToMyAccountLink() {
		waitElementToBeClickable(driver, UserReviewProductPageUI.LOGOUT_LINK);
		clickToElement(driver, UserReviewProductPageUI.LOGOUT_LINK);
	}


}
