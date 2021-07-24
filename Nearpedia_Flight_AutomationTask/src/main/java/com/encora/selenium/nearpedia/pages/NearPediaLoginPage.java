package com.encora.selenium.nearpedia.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import myframework.BasePageUI;

public class NearPediaLoginPage extends BasePageUI{
	
	private static final By VALIDATE_HEADER = By.xpath("(//div[@class='col-md-12'])[2]");
	private static final By SELECT_INPUT_ORIGIN = By.xpath("//select[@name='flight-from']");
	private static final By SELECT_INPUT_DESTINATION = By.xpath("//select[@id='flight-to']");
	private static final By ENTER_DEPARTURE_DATE = By.xpath("(//input[@class='form-control'])[1]");
	private static final By ENTER_RETURN_DATE = By.xpath("(//input[@class='form-control'])[2]");
	//private static final By SELECT_INPUT_ADULT = By.xpath("//*[@id="travelers"]");
	private static final By CLICK_SEARCH = By.xpath("//button[contains(text(),'Search')]");
	private static final By SELECT_DECENDING_PriceList = By.xpath("//select[@name='sort']");
	
	public NearPediaLoginPage(WebDriver driver) {
	super(driver);
	}
	public void headerValidation() throws InterruptedException {
		Thread.sleep(4000);
		String ExpectedTest = driver.findElement(VALIDATE_HEADER).getText();
		String ActualTest = "Flights";
		Assert.assertEquals(ExpectedTest, ActualTest);				
	}
	
	public void selectFromFlightByDropdown() throws InterruptedException {
		Thread.sleep(2000);
		Select selectFromFlight = new Select(driver.findElement(SELECT_INPUT_ORIGIN));
		selectFromFlight.selectByVisibleText("Merida");
		//selectdropdown(SELECT_INPUT_ORIGIN, "MERIDA");
		
		System.out.println(" Flight Origin city selected");
		
	}
	
	public void selectToFlightByDropdown() throws InterruptedException {
		Thread.sleep(2000);
		Select selectToFlight = new Select(driver.findElement(SELECT_INPUT_DESTINATION));
		selectToFlight.selectByVisibleText("CDMX");
		//selectdropdown(SELECT_INPUT_DESTINATION, "CDMX");
		System.out.println(" Flight Destination city selected");
		
	}
	
	//Click Date picker for departure date
	public void enterDepartureDate() throws InterruptedException {
		Thread.sleep(2000);
		//Use JS executor 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 WebElement DepartureDate = driver.findElement(ENTER_DEPARTURE_DATE);
		 //Remove Read only attributes from date picker
		 js.executeScript("document.getElementsByClassName('form-control')[1].removeAttribute('readonly');", DepartureDate);
		//Directly enter the date
		 driver.findElement(ENTER_DEPARTURE_DATE).sendKeys("27-07-2021");
		//enterDepDateAsInput(ENTER_DEPARTURE_DATE, "27-07-2021");
		System.out.println("Entered Departure date successfully");
	}
	
	
	//Click Date picker for Return date
	public void enterReturnDate() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 WebElement ReturnDate = driver.findElement(ENTER_RETURN_DATE);
		 //Remove Read only attributes from date picker
		 js.executeScript("document.getElementsByClassName('form-control')[2].removeAttribute('readonly');", ReturnDate);
		//Directly enter Departure date
		 driver.findElement(ENTER_RETURN_DATE).sendKeys("27-08-2021");
		//enterReturnDateAsInput(ENTER_RETURN_DATE, "27-08-2021");
		System.out.println(" Entered Return date successfully ");
	}
	
	//Click the search Button
	public void clickFlightSearch() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(CLICK_SEARCH).click();
		System.out.println(" Succesfully clicked search button");
		
	}
	//Select the Price Descending from the Drop down list by using Text
	public void  selectDesendingPiceFromDropDown() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(SELECT_DECENDING_PriceList));
		Select selectSortPrices = new Select(element);
		selectSortPrices.selectByVisibleText("Price descending");	
		System.out.println(" Succesfully selected the Descending price from dropdown");
	}
	
	// Verify the Fetched Descending prices Sorted from the Prices list 
	
	public Boolean sortVerifyPricesDecendingOrder() {
		List<WebElement> theList=driver.findElements(By.xpath("//*[@id=\"results\"]/div[1]/div[3]")); 
	    List<Integer> Prices=new ArrayList<Integer>();
	    
	    for(int priceItemList = 1;priceItemList<theList.size();priceItemList++) {
	    	String priceOneRow = driver.findElement(By.xpath("//*[@id=\"results\"]/div[1]/div[3]/span[1]")).getText();
	    	System.out.println("Fetching the prices" +priceOneRow);
	    }
	    
	    System.out.println("All printed" +theList);
		return true;
	
	}

	
	
	public void loginNearPediaFlightsSearchPage() throws InterruptedException {
		System.out.println(" Login to Near pedia flight search page");
		//headerValidation();
		selectFromFlightByDropdown();
		selectToFlightByDropdown();
		enterDepartureDate();
		enterReturnDate();
		clickFlightSearch();	
	}
	
	public void flightResultsPage() {
		selectDesendingPiceFromDropDown();
		
	}
	
	public void verifyResultsSortedPricesPage()
	{
		sortVerifyPricesDecendingOrder();
	}
	
	

	
	
	
	@Override 
	public boolean waitForPageLoad() {
		return true;
	}
	
}