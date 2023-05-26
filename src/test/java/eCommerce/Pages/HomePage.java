package eCommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

	//Elements
	//Images
	@FindBy(xpath = "//img[@class='large']") WebElement imgLogoMagento;
	@FindBy(xpath = "//img[@title='Additional Options']") WebElement imgLogoPayPal;
	
	//Text (for asserts)
	@FindBy(tagName = "h2") WebElement assertText;	
	
	//Buttons
	@FindBy(xpath = "//header/div[1]/div[2]/div[1]/a[1]") WebElement btnLogin;
	@FindBy(xpath = "//header/div[1]/div[2]/div[1]/div[1]/a[1]") WebElement btnCart;

	//Text bars and search buttons
	@FindBy(id = "search") WebElement txtSearchBar;
	@FindBy(css = "button[title='Search']") WebElement btnSearchBar;
	@FindBy(id = "newsletter") WebElement txtNewsLetter;
	@FindBy(xpath = "//button[@title='Subscribe']") WebElement btnNewsLetter;
	
	//Links
	@FindBy(xpath = "//a[contains(text(),'Mobile')]") WebElement linkMobile;
	@FindBy(xpath = "//a[contains(text(),'TV')]") WebElement linkTV;
	@FindBy(xpath = "//a[contains(text(),'About Us')]") WebElement linkAboutUs;
	@FindBy(xpath = "//a[contains(text(),'Contact Us')]") WebElement linkContactUs;	
	@FindBy(xpath = "//a[contains(text(),'Customer Service')]") WebElement linkCustomerService;
	@FindBy(xpath = "//a[contains(text(),'Privacy Policy')]") WebElement linkPrivacyPolicy;
	@FindBy(xpath = "//a[contains(text(),'Site Map')]") WebElement linkSiteMap;
	@FindBy(xpath = "//a[contains(text(),'Search Terms')]") WebElement linkSearchTerms;	
	@FindBy(xpath = "//a[contains(text(),'Advanced Search')]") WebElement linkAdvancedSearch;
	@FindBy(xpath = "//a[contains(text(),'My Account')]") WebElement linkMyAccount;
	@FindBy(xpath = "//a[contains(text(),'Orders and Returns')]") WebElement linkOrdersReturns;
	
	
	//Constructor
	public HomePage (WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory (driver, 15), this);
	}
	

	//Actions
	public void goto_searchMobile() {
		linkMobile.click();
	}
	
	public String assertText() {
		return assertText.getText();
	}
	
}
