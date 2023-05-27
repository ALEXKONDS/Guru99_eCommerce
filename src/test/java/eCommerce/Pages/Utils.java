package eCommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Utils {
	
	//Variables
	String url = "http://live.techpanda.org/"; 
	String evidenceFolder = "..\\Guru99.eCommerce\\evidence\\";
	
	String homepageDemoSiteMessage = "THIS IS DEMO SITE FOR   ";
	String checkoutErrorMessage = "Some of the products cannot be ordered in requested quantity.";
	String checkoutEmptyCartMessage = "SHOPPING CART IS EMPTY";
	
	//Constructor
	public Utils (WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory (driver, 15), this);
	}
	
	
	//Actions
	public String returnURL() {
		return url;
	}
	
	public String returnEvidenceFolder() {
		return evidenceFolder;
	}
	
	public String returnHomePageDemoSiteMessage() {
		return homepageDemoSiteMessage;
	}
	
	public String returnCheckoutErrorMessage() {
		return checkoutErrorMessage;
	}
	
	public String returnCheckoutEmptyCartMessage() {
		return checkoutEmptyCartMessage;
	}	
	
}
