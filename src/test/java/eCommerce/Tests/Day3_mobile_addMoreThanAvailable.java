package eCommerce.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

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
import eCommerce.Pages.CheckoutPage;

public class Day3_mobile_addMoreThanAvailable {
	
	WebDriver driver;
	File screenshotEvidence;
	Faker faker = new Faker();
	
	Utils utils;
	HomePage homepage;
	SearchMobilePage searchmobile;
	CheckoutPage checkoutpage;
			
	
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
	public void addItemstoCart_TooMany() throws IOException {
		
		//Go to mobile search
		homepage = new HomePage(driver);
		homepage.click_searchMobile();

		//Click on Add to Cart button and go to checkout page
		searchmobile = new SearchMobilePage(driver);
		searchmobile.addToCart_Xperia();
		
		//Change quantity to > 500. Assert error message is shown to user
		checkoutpage = new CheckoutPage(driver);
		checkoutpage.editQuantity(faker.number().numberBetween(501, 10000));
		Assert.assertEquals(checkoutpage.assert_ReturnMsgError(), utils.returnCheckoutErrorMessage());
		//Screenshot: Error message shown when quantity is higher than max
		screenshotEvidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotEvidence, new File(utils.returnEvidenceFolder() + "Day 3\\message_TooManyItems.png"));
		
		//Empty cart. Assert empty cart message is shown to user
		checkoutpage.btn_EmptyCart();
		Assert.assertEquals(checkoutpage.assert_ReturnMsgEmptyCart(), utils.returnCheckoutEmptyCartMessage());
		//Screenshot: Error message shown when quantity is higher than max
		screenshotEvidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotEvidence, new File(utils.returnEvidenceFolder() + "Day 3\\message_EmptyCart.png"));
		
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

	

