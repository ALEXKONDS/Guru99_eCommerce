package eCommerce.Tests;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;

import java.io.File;

import eCommerce.Pages.Utils;
import eCommerce.Pages.HomePage;
import eCommerce.Pages.ProductComparePage;
import eCommerce.Pages.SearchMobilePage;
import eCommerce.Pages.CheckoutPage;

public class Day4_mobile_compareItems {
	
	WebDriver driver;
	File screenshotEvidence;
	Faker faker = new Faker();
	
	Utils utils;
	HomePage homepage;
	SearchMobilePage searchmobile;
	CheckoutPage checkoutpage;
	ProductComparePage productcompare;
			
	
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
	public void addItemstoCart_TooMany() throws IOException, InterruptedException {
		
		//Go to mobile search
		homepage = new HomePage(driver);
		homepage.click_searchMobile();
		
		searchmobile = new SearchMobilePage(driver);
		//Click on Add to Compare
		searchmobile.click_AddToCompare_SonyXperia();
		searchmobile.click_AddToCompare_AppleiPhone();
		
		
		//Store main window in variable
		String mainHandle = driver.getWindowHandle();
		
		//Click on Compare button
		driver.findElement(By.cssSelector("button[title='Compare']")).click();
		
		Set<String> allHandles = driver.getWindowHandles();
		
		for (String windowHandle : allHandles) {
			if (mainHandle.equals(windowHandle)) {
				
			} else {
				//Switch to compare window
				driver.switchTo().window(windowHandle);
				
				//Assert: COMPARE PRODUCTS text is present
				productcompare = new ProductComparePage(driver);
				Assert.assertEquals(productcompare.return_textAssert_Compare(), utils.returnCompareProductsMessage());
				
				
				//Screenshot: New window comparing items
				Thread.sleep(3000);
				screenshotEvidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshotEvidence, new File(utils.returnEvidenceFolder() + "Day 4\\compareItems.png"));
				
				//Click on close window
				driver.findElement(By.xpath("/html/body/div/div[2]/button")).click();
				
				//Return to main window
				driver.switchTo().window(mainHandle);
			}
		}
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

	

