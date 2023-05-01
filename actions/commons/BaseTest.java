package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	protected final Log log;
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	public WebDriver getBrowserDriver(String browserName, String userURL) {
		BrowserName browser = BrowserName.valueOf(browserName.toUpperCase());
		switch(browser)	{
		case FIREFOX:
			driver = WebDriverManager.firefoxdriver().create();
			//System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			//driver = new FirefoxDriver();
			break;
		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			//System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			//driver = new ChromeDriver();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			//System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
			//driver = new EdgeDriver();
			break;
		case OPERA:
			driver = WebDriverManager.operadriver().create();
			//System.setProperty("webdriver.opera.driver", projectPath + "/browserDrivers/operadriver");
			//driver = new OperaDriver();
			break;
		default:
			throw new RuntimeException("Cannot find browser name.");
		}
		
		driver.manage().timeouts().implicitlyWait(GlobalConstant.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(userURL);
		return driver;
	}
	
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	public int generateRandomNumber() {
		Random email = new Random();
		return email.nextInt(9999);
	}
}
