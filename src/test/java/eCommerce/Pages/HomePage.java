package eCommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

	//Elements
	@FindBy(tagName = "h2") WebElement textAssert_HomePage;	
	@FindBy(xpath = "//a[contains(text(),'Mobile')]") WebElement text_Mobile;
	
	
	//Constructor
	public HomePage (WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory (driver, 15), this);
	}
	

	//Actions
	public void click_searchMobile() {
		text_Mobile.click();
	}
	
	public String return_textAssert_Homepage() {
		return textAssert_HomePage.getText();
	}
	
}
