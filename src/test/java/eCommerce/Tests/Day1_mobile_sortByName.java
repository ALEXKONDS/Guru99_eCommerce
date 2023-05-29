package eCommerce.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;

import java.io.File;

import eCommerce.Pages.Utils;
import eCommerce.Pages.HomePage;
import eCommerce.Pages.SearchMobilePage;


public class Day1_mobile_sortByName {

	WebDriver driver;
	File screenshotEvidence;
	
	Utils utils;
	HomePage homePage;
	SearchMobilePage searchMobilePage;

	
	@BeforeSuite
	public void startSuite() {
		System.out.println("Test suite has started!");
	}
	
	
	@BeforeTest
	@Parameters ("browser")
	public void setUp(String browser) throws IOException {
	
		switch (browser) {
			case "Chrome": {
				driver = new ChromeDriver();
				break;
			}
			case "Edge": {
				driver = new EdgeDriver();
				break;
			}
			case "Firefox": {
				driver = new FirefoxDriver();
				break;
			}
		}
		
		utils = new Utils(driver);
		driver.get(utils.returnURL());
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}
	
	
	@Test
	@Parameters ("browser")
	public void mobile_sort_byName() throws IOException {
		
		//Assert page title is Home page, if ok declare homePage
		Assert.assertEquals(driver.getTitle(), "Home page");
		homePage = new HomePage(driver);		
		
		//Assert text is present in page, if ok click on mobile button
		Assert.assertEquals(homePage.return_textAssert_Homepage(), utils.returnHomePageDemoSiteMessage());
		homePage.click_searchMobile();
		
		//Assert page title is Mobile, if ok sort items by name
		Assert.assertEquals(driver.getTitle(), "Mobile");
		searchMobilePage = new SearchMobilePage(driver);
		searchMobilePage.sortBy_Name("http://live.techpanda.org/index.php/mobile.html?dir=asc&order=name");
		
		//Assert new url is sorting by name
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/mobile.html?dir=asc&order=name");
		
		//Evidence screenshot
		screenshotEvidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotEvidence, new File(utils.returnEvidenceFolder() + "Day 1\\mobile_sortByName.png"));	

	}
	
	
	@AfterMethod
	public void returnHome() {
		driver.manage().deleteAllCookies();
		driver.get(utils.returnURL());
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
	@AfterSuite
	public void endSuite() {
		System.out.println("Test suite has ended!");
	}
}
