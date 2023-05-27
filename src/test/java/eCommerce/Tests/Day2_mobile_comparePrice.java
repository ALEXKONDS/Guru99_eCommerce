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
import eCommerce.Pages.MobileDetailsPage_Xperia;
import eCommerce.Pages.SearchMobilePage;

public class Day2_mobile_comparePrice {

	WebDriver driver;
	File screenshotEvidence;
	
	Utils utils;
	HomePage homepage;
	SearchMobilePage searchmobile;
	MobileDetailsPage_Xperia mobiledetailspage_xperia;
	
	
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
	public void comparePrice() throws IOException {
		
		//Go to mobile search
		homepage = new HomePage(driver);
		homepage.goto_searchMobile();
		
		//Evidence screenshot
		screenshotEvidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotEvidence, new File(utils.returnEvidenceFolder() + "Day 2\\comparePrice_mobilePage.png"));
		
		//Save price to variable and go to detail page of Xperia
		searchmobile = new SearchMobilePage(driver);
		String assert_Price_Xperia = searchmobile.assert_Price_Xperia();
		searchmobile.goto_Details_Xperia();
		
		//Assert stored variable with price on detail page
		mobiledetailspage_xperia = new MobileDetailsPage_Xperia(driver);
		Assert.assertEquals(assert_Price_Xperia, mobiledetailspage_xperia.assert_ReturnXperiaPrice());
		
		//Evidence screenshot
		screenshotEvidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotEvidence, new File(utils.returnEvidenceFolder() + "Day 2\\comparePrice_mobileDetails.png"));

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
