package myframework;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	private static final Logger LOGGER = Logger.getLogger(BaseTest.class.getName());
	protected WebDriver driver;
	
	//Set up browser configuration using chrome options
	protected void browserConfig(String browser) {
		System.setProperty("webdriver.chrome.driver","//E:chromedriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
		driver.get("file:///D:/site/flights.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();		
		
	}
	
	@AfterMethod (alwaysRun = true)
	public void tearDown() throws Exception
	{
		if(driver != null) {
			try {
				//driver.close();
				//driver.quit();
			}
			catch(Exception e) {
				//LOGGER.error(e);
				System.out.println("Exception occured try to fix it");
			}
		}
	}

	
	

}
