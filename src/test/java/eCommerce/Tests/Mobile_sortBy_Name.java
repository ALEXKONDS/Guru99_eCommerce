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

import eCommerce.Pages.HomePage;
import eCommerce.Pages.SearchMobile;


public class Mobile_sortBy_Name {

	WebDriver driver;
	String url = "http://live.techpanda.org/";
	String evidenceFolder = "..\\Guru99.eCommerce\\evidence\\Day 1\\";
	File screenshotEvidence;
	
	HomePage homePage;
	SearchMobile searchMobile;
	
	
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
		
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}
	
	
	@Test
	@Parameters ("browser")
	public void mobile_sort_byName() throws IOException {
		
		//Assert page tittle is Home page, if ok declare homePage
		Assert.assertEquals(driver.getTitle(), "Home page");
		homePage = new HomePage(driver);		
		
		//Assert text is present in page, if ok click on mobile button
		Assert.assertEquals(homePage.assertText(), "THIS IS DEMO SITE FOR   ");
		homePage.goto_searchMobile();
		
		//Assert page tittle is Mobile, if ok sort items by name
		Assert.assertEquals(driver.getTitle(), "Mobile");
		searchMobile = new SearchMobile(driver);
		searchMobile.sortBy_Name("http://live.techpanda.org/index.php/mobile.html?dir=asc&order=name");
		
		//Assert new url is sorting by name
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/mobile.html?dir=asc&order=name");
		
		//Evidence screenshot
		screenshotEvidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotEvidence, new File(evidenceFolder + "mobile_sortBy_Name.png"));	

	}
	
	
	@AfterMethod
	public void returnHome() {
		driver.manage().deleteAllCookies();
		driver.get(url);
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
