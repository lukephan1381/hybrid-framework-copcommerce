package pageObjects.jquery.uploadfile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.uploadfile.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitElementToBeVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED, fileName);	
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getElements(driver, HomePageUI.START_BUTTON);
		
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
	}

	public boolean isFileLinkUploadedByName(String fileName) {
		waitElementToBeVisible(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);	
	}

	public boolean isFileImageUploadedByName(String fileName) {
		waitElementToBeVisible(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
	}
}
