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
import eCommerce.Pages.Mobile_Details_Xperia;
import eCommerce.Pages.SearchMobile;

public class Mobile_comparePrice {

	WebDriver driver;
	String url = "http://live.techpanda.org/";
	String evidenceFolder = "..\\Guru99.eCommerce\\evidence\\Day 2\\";
	File screenshotEvidence;
	
	HomePage homePage;
	SearchMobile searchMobile;
	Mobile_Details_Xperia mobileDetailsXperia;
	
	
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
	public void comparePrice() throws IOException {
		
		//Go to mobile search
		homePage = new HomePage(driver);
		homePage.goto_searchMobile();
		
		//Evidence screenshot
		screenshotEvidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotEvidence, new File(evidenceFolder + "price_MobilePage.png"));
		
		//Save price to variable and go to detail page of Xperia
		searchMobile = new SearchMobile(driver);
		String assert_Price_Xperia = searchMobile.assert_Price_Xperia();
		searchMobile.goto_Details_Xperia();
		
		//Assert stored variable with price on detail page
		mobileDetailsXperia = new Mobile_Details_Xperia(driver);
		Assert.assertEquals(assert_Price_Xperia, mobileDetailsXperia.assert_Xperia_Price());
		
		//Evidence screenshot
		screenshotEvidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotEvidence, new File(evidenceFolder + "price_MobileDetails.png"));

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
