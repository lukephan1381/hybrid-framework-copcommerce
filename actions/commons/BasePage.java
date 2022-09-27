package commons;

import java.util.Set;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
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
}
