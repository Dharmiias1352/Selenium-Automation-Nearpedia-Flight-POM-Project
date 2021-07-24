package myframework;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageUI extends WebBasePage  {
	private static Logger LOGGER = Logger.getLogger(BasePageUI.class.getName());
	public WebDriver driver;
	
	public BasePageUI(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super();
		this.driver=driver;
	}
	
	public void click(By locator) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = WaitUtils.waitForElement(locator, driver, 0);
		LOGGER.info("Click on -" + element.getText() + " - " +locator);
		element.click();
		}
		catch(Exception e) {
		LOGGER.info("Failed from clicking on" +locator);	
		}
	}
	
	public void selectdropdown(By locator, String value) {
		try {
			WebElement element = WaitUtils.waitForElement(locator, driver, 0);
			LOGGER.info("Select -" + value + "element from selector -" +locator);
			Select flightServicesDropdown = new Select (element);
			flightServicesDropdown.selectByVisibleText(value);
			
		}catch(Exception e) {
			
			LOGGER.info("Failed Select from -" + value + "from select" + locator);
		}
	}
	
	public void enterInput(By locator, String value) {
		try {
			WebElement element =WaitUtils.waitForElement(locator, driver, 0);
			LOGGER.info("Enter value -" + value + "- in -" + locator);
			element.sendKeys(value);
		
		}catch(Exception e) {
			LOGGER.info("Failed to inster value-" +locator);
		}
	}
	
	public void enterDepDateAsInput(By locator, String value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement element = WaitUtils.waitForElement(locator, driver, 0);
			LOGGER.info("Enter the date using this" +locator);
			js.executeScript("document.getElementsByClassName('form-control')[1].removeAttribute('readonly');", element);
			WebElement EnterDateAfterRemovedReadOnly = WaitUtils.waitForElement(locator, driver, 0);
			EnterDateAfterRemovedReadOnly.sendKeys(value);
			
		}catch(Exception e) {
			LOGGER.info("Unable to pick the Departuredate as input-" + locator);
		}
	}
	
	public void enterReturnDateAsInput(By locator, String value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement element = WaitUtils.waitForElement(locator, driver, 0);
			LOGGER.info("Enter the date using this" +locator);
			js.executeScript("document.getElementsByClassName('form-control')[2].removeAttribute('readonly');", element);
			WebElement EnterDateAfterRemovedReadOnly = WaitUtils.waitForElement(locator, driver, 0);
			EnterDateAfterRemovedReadOnly.sendKeys(value);
			
		}catch(Exception e) {
			LOGGER.info("Unable to pick the Returndate as input-" + locator);
		}
	}
	public boolean waitForPageLoad() {
		// TODO Auto-generated method stub
		return false;
	}

}
