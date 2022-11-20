package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	public WebDriver getBrowserDriver(String browserName) {
		switch(browserName)	{
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			driver = new FirefoxDriver();
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			driver = new ChromeDriver();
			break;
		case "Edge":
			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
			driver = new EdgeDriver();
			break;
		case "Opera":
			System.setProperty("webdriver.opera.driver", projectPath + "/browserDrivers/operadriver");
			driver = new OperaDriver();
			break;
		default:
			throw new RuntimeException("Cannot find browser name.");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}
	
	public int generateRandomNumber() {
		Random email = new Random();
		return email.nextInt(9999);
	}
}
