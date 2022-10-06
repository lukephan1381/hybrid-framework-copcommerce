package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class User_01_RepeatYourSelf {
	
	String githubToken = "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";
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Select select;
	String emailAddress = "lukephan" + generateRandomNumber() + "@auto.vn";
	
	@BeforeClass
	public void beforeClass() {

		
		if (osName.startsWith("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
		}
		else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@Test
	public void User_01_Register() {

		//Click on Register button
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		
		//Select gender
		driver.findElement(By.xpath("//span[@class='male']")).click();
		
		//Input first name & last name
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Luke");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Luke");
		
		//Select birthday
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select.selectByVisibleText("28");
		
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText("January");
		
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText("1991");
		
		//Input email address
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
		
		//Input & confirm password
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("qqqq1111");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("qqqq1111");
		
		//Click REGISTER button
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		
		//Verify success message
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
		
		//logout of current account
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
	}
	
	@Test
	public void User_02_Login() {

		//click on login button
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		
		//input Email address & password
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("qqqq1111");
		
		//submit login
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//a[@class='ico-logout']")).getText(), "Log out");
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public int generateRandomNumber() {
		Random email = new Random();
		return email.nextInt(9999);
	}
	
}
