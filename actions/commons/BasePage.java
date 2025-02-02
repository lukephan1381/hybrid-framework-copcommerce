package commons;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIs.jquery.uploadfile.HomePageUI;
import pageUIs.nopcommerce.BasePageUI;

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
	
	public Set<Cookie> getAllCookies(WebDriver driver){
		return driver.manage().getCookies();
	}
	
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}
	
	public Alert waitAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver,15).until(ExpectedConditions.alertIsPresent());
	}
	
	public void alertAccept(WebDriver driver) {
		waitAlertPresence(driver).accept();
	}
	
	public void alertCancel(WebDriver driver) {
		waitAlertPresence(driver).dismiss();
	}
	
	public void alertGetText(WebDriver driver) {
		waitAlertPresence(driver).getText();
	}
	
	public void alertSendKeys(WebDriver driver, String alertText) {
		waitAlertPresence(driver).sendKeys(alertText);
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
	
	public void uploadMultipleFiles(WebDriver driver, String...fileNames) {
		//String filePath = System.getProperty("user.dir") + "\\uploadFiles\\";
		String filePath = GlobalConstant.UPLOAD_FILE;
		String fullFileName = "";
		
		for (String file:fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getElement(driver,HomePageUI.UPLOAD_FILE).sendKeys(fullFileName);
	}
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}
	
	public String getRestParameter(String locator, String... params) {
		locator = String.format(locator, (Object[])params);
		return locator;
	}
	
	public By getByLocator(String locator) {
		By by = null;
		
		if (locator.startsWith(("id=")) || locator.startsWith(("Id=")) || locator.startsWith(("ID="))) {
			locator = locator.substring(3);
			by = By.id(locator);
		}
		else if (locator.startsWith("class=") || locator.startsWith("Class=") || locator.startsWith("CLASS=")) {
			locator = locator.substring(6);
			by = By.className(locator);
		}
		else if (locator.startsWith("name=") || locator.startsWith("Name=") || locator.startsWith("NAME=")) {
			locator = locator.substring(5);
			by = By.name(locator);
		}
		else if (locator.startsWith("css=") || locator.startsWith("Css=") || locator.startsWith("CSS=")) {
			locator = locator.substring(4);
			by = By.cssSelector(locator);
		}
		else if (locator.startsWith("xpath=") || locator.startsWith("Xpath=") || locator.startsWith("XPath=") || locator.startsWith("XPATH=")) {
			locator = locator.substring(6);
			by = By.xpath(locator);
		}
		else if (locator.startsWith("tagname=") || locator.startsWith("Tagname=") || locator.startsWith("XPath=") || locator.startsWith("TAGNAME=")) {
			locator = locator.substring(6);
			by = By.tagName(locator);
		}
		else {
			throw new RuntimeException("<---Your locator is invalid.--->");
		}
		return by;
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String... params) {
		getElement(driver, getRestParameter(locator, params)).click();
	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String valueToSendKey) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(valueToSendKey);
	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String valueToSendKey, String... params) {
		getElement(driver, getRestParameter(locator, params)).clear();
		getElement(driver, getRestParameter(locator, params)).sendKeys(valueToSendKey);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String textValue) {
		new Select(getElement(driver, locator)).selectByVisibleText(textValue);;
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String textValue, String...params) {
		new Select(getElement(driver, getRestParameter(locator, params))).selectByVisibleText(textValue);;
	}
	
	public String getSelectedItemInDropdown(WebDriver driver, String locator) {
		return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
	}
	
	public String getSelectedItemInDropdown(WebDriver driver, String locator, String...params) {
		return new Select(getElement(driver, getRestParameter(locator, params))).getFirstSelectedOption().getText();
	}
	
	public Boolean isDropdownMultiple(WebDriver driver, String locator) {
		return new Select(getElement(driver, locator)).isMultiple();
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
	
	public String getElementAttribute(WebDriver driver, String locator, String attributeName, String...params) {
		return  getElement(driver,getRestParameter(locator, params)).getAttribute(attributeName);
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
	
	public int getElementsSize(WebDriver driver, String locator, String... params) {
		return getElements(driver,getRestParameter(locator, params)).size();
	}
	
	public void checkOnCheckboxOrRadio(WebDriver driver, String locator) {
		if (!isElementSelected(driver, locator)) {
			clickToElement(driver, locator);
		}
	}
	
	public void checkOnCheckboxOrRadio(WebDriver driver, String locator, String...params) {
		if (!isElementSelected(driver, getRestParameter(locator, params))) {
			clickToElement(driver, getRestParameter(locator, params));
		}
	}
	
	public void uncheckToCheckbox(WebDriver driver, String locator) {
		if (isElementSelected(driver, locator)){
			clickToElement(driver, locator);
		}
	}
	
	public void uncheckToCheckbox(WebDriver driver, String locator, String...params) {
		if (isElementSelected(driver, getRestParameter(locator, params))){
			clickToElement(driver, getRestParameter(locator, params));
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String...params) {
		return getElement(driver,getRestParameter(locator, params)).isDisplayed();
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		System.out.println("Start time: " + new Date().toString());
		overrideImplicitTimeout(driver,5);
		List<WebElement> elements = getElements(driver, locator);
		overrideImplicitTimeout(driver,30);
		
		if (elements.size()==0) {
			System.out.println("Element NOT in DOM");
			System.out.println("End time: " + new Date().toString());
			return true;
		}
		else if (elements.size()>0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but NOT displayed ");
			System.out.println("End time: " + new Date().toString());
			return true;
		}
		else {
			System.out.println("Element in DOM and displayed");
			System.out.println("End time: " + new Date().toString());
			return false;
		}
	}
	
	public void overrideImplicitTimeout(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void moveToElement(WebDriver driver, String locator) {
		new Actions(driver).moveToElement(getElement(driver, locator)).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		new Actions(driver).doubleClick(getElement(driver, locator)).perform();
	}
	
	public void rightClickElement(WebDriver driver, String locator) {
		new Actions(driver).contextClick(getElement(driver, locator)).perform();
	}
	
	public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
		new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();;
	}
	
	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		new Actions(driver).sendKeys(getElement(driver, locator), key).perform();
	}
	
	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key, String... params) {
		new Actions(driver).sendKeys(getElement(driver, getRestParameter(locator, params)), key).perform();
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Javascripts executor*/
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		return status;
	}
	
	public boolean isImageLoaded(WebDriver driver, String locator, String...params) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, getRestParameter(locator, params)));
		return status;
	}
	
	/* Waits */
	
	public void waitElementToBeVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitElementToBeVisible(WebDriver driver, String locator, String... params) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getRestParameter(locator, params))));
	}
	
	public void waitElementToBeClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}
	
	public void waitElementToBeClickable(WebDriver driver, String locator, String... params) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(getByLocator(getRestParameter(locator, params))));
	}
	
	public void waitListElementsToBeVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
	}
	
	public void waitElementToBeInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitListElementsToBeInvisibile(WebDriver driver, String locator) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, locator)));
	}
	
	public void waitElementUndisplayed(WebDriver driver, String locator) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitElementPresence(WebDriver driver, String locator) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
	}
	
	public void waitListElementsPresence(WebDriver driver, String locator) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
	}
	
	/* Pattern Object */
	
	public void inputToTextboxByID(WebDriver driver, String attributeValue, String textValue) {
		waitElementToBeVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, attributeValue);
		sendKeyToElement(driver,BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textValue, attributeValue);
	}
	

	public void clickToButtonByText(WebDriver driver, String buttonText) {
		waitElementToBeVisible(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
	}
	
	public void selecToDropdownByName(WebDriver driver, String attributeName, String value) {
		waitElementToBeClickable(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, attributeName);
		selectItemInDropdown(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, value, attributeName);
	}
	
	public void clickToRadioByLabel(WebDriver driver, String labelName) {
		waitElementToBeClickable(driver, BasePageUI.DYNAMIC_RADIO_BY_LABEL, labelName);
		checkOnCheckboxOrRadio(driver, BasePageUI.DYNAMIC_RADIO_BY_LABEL, labelName);
	}
	
	public void clickToCheckboxByLabel(WebDriver driver, String labelName) {
		waitElementToBeClickable(driver, BasePageUI.DYNAMIC_CHECKBOX_BY_LABEL, labelName);
		checkOnCheckboxOrRadio(driver, BasePageUI.DYNAMIC_CHECKBOX_BY_LABEL, labelName);
	}
	
	public String getTextBoxValueByID(WebDriver driver, String textboxID) {
		waitElementToBeVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}
	
	public String getDropDownSelectedItemByName(WebDriver driver, String attributeName) {
		waitElementToBeVisible(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, attributeName);
		return getSelectedItemInDropdown(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, attributeName);
	}

}
