package javaBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Topic_17_Assert extends BaseTest{
	WebDriver driver;
	SoftAssert soft;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		driver = WebDriverManager.firefoxdriver().create();
		soft = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	}
	
	@Test
	public void TestCase() {
		System.out.println("Step 01 - Input to email textbox");
		driver.findElement(By.id("email")).sendKeys("");

		System.out.println("Step 02 - Input to password textbox");
		driver.findElement(By.id("pass")).sendKeys("");

		System.out.println("Step 03 - Click to Login button");
		driver.findElement(By.id("send2")).click();

		// First Pass (5)
		System.out.println("Step 05 - Verify error message displayed");
		verifyEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");

		// Second Fail (10)
		System.out.println("Step 10 - Verify error message displayed");
		verifyEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field");

		// Pass (45)
		System.out.println("Step 45 - Verify .....");
		//verifyTrue(isElementDisplayed("//button[@id='send2']"));
		verifyTrue(driver.findElement(By.id("send2")).isDisplayed());

		// Third Fail (50)
		System.out.println("Step 50 - Verify .....");
		//verifyTrue(isElementDisplayed("//button[@id='send_failed_not_found']"));
		verifyTrue(driver.findElement(By.id("send_failed_not_found")).isDisplayed());

		// Pass (65)
		System.out.println("Step 65 - Verify .....");
		//verifyTrue(isElementDisplayed("//button[@id='send2']"));
		verifyTrue(driver.findElement(By.id("send2")).isDisplayed());

		
		// Fourth Fail (76)
		System.out.println("Step 76 - Verify .....");
		//verifyTrue(isElementDisplayed("//button[@id='send_failed_not_found']"));
		verifyTrue(driver.findElement(By.id("send_failed_not_found")).isDisplayed());


		// Required
		soft.assertAll();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
