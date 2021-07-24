package com.encora.nearpedia.flights.test;

import org.testng.annotations.Test;

import com.encora.selenium.nearpedia.pages.NearPediaLoginPage;

import myframework.BaseTest;

public class FlightUserLoginTest extends BaseTest{

	private String browser = "chrome";
	@Test
	public void loginNearpediaFlightsSelectionPage() throws InterruptedException {	
		
		super.browserConfig(browser);
		//Flights search page
		NearPediaLoginPage nploginpage = new NearPediaLoginPage(driver);
		nploginpage.loginNearPediaFlightsSearchPage();
		
		//Flight Results page 
		NearPediaLoginPage npresultspage = new NearPediaLoginPage(driver);
		npresultspage.flightResultsPage();
		
		//verify the the descending prices list sorted
		NearPediaLoginPage verifyDescendingPricesListSorted = new NearPediaLoginPage(driver);
		verifyDescendingPricesListSorted.verifyResultsSortedPricesPage();
		
	}

}
