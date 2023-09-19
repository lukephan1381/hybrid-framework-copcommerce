package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

public class UserComputerPageObject extends UserHeaderPageObject{
	WebDriver driver;
	
	public UserComputerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToSubCategoryByName(String string) {
		// TODO Auto-generated method stub
		
	}
}
