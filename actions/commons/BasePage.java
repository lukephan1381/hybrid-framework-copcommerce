package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	/* Web Browser */
	
	public void openURL(WebDriver driver, String pageURL) {
		driver.get(pageURL);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void navigatePageBack(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void navigatePageForward(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void pageRefresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void alertPresentWait(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void alertCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void alertGetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	
	public void alertSendKeys(WebDriver driver, String alertText) {
		driver.switchTo().alert().sendKeys(alertText);
	}
	
	public void switchToWindowByID(WebDriver driver, String parentTab) {
		Set<String> allTabs = driver.getWindowHandles();
		for (String currentTab : allTabs) {
			if (!currentTab.equals(parentTab))
				;
			driver.switchTo().window(currentTab);
		}
	}
	
	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allTabs = driver.getWindowHandles();
		for (String currentTab : allTabs) {
			driver.switchTo().window(currentTab);
			String currentTabTitle = driver.getTitle();
			if (currentTabTitle.equals(title)) {
				break;
			}
		}
	}
	
	public void closeAllWindowsExceptParent(WebDriver driver, String parentTab) {

		Set<String> allTabs = driver.getWindowHandles();
		for (String currentTab : allTabs) {
			if (!currentTab.equals(parentTab)) {
				driver.switchTo().window(currentTab);
				driver.close();
			}
		}
		driver.switchTo().window(parentTab);
	}
	
	/* Web Element*/
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String valueToSendKey) {
		getElement(driver, locator).sendKeys(valueToSendKey);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String textValue) {
		new Select(getElement(driver, locator)).selectByVisibleText(textValue);;
	}
	
	public String getSelectedItemInDropdown(WebDriver driver, String locator) {
		return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedTextItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(3);

		List<WebElement> allDropdownItems = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));
		
		for (WebElement item : allDropdownItems) {
			String actualTextItem = item.getText();
			System.out.println(item);
			if (actualTextItem.equals(expectedTextItem)) {
				//System.out.println(actualTextItem);
				//jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				item.click();
				break;
			}
		}
	}
	
	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
	}
	
	public void getElementCSSValue(WebDriver driver, String locator, String propertyName) {
		getElement(driver, locator).getCssValue(propertyName);
	}
	
	public String getHexColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementsSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	
	public void checkOnCheckboxOrRadio(WebDriver driver, String locator) {
		if (!getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}
	
	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		if (getElement(driver, locator).isSelected()){
			getElement(driver, locator).click();
		}
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Boolean isDropdownMultiple(WebDriver driver, String locator) {
		return new Select(getElement(driver, locator)).isMultiple();
	}
	
	
	
}
