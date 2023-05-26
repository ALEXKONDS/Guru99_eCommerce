package eCommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Mobile_Details_Xperia {

	//Elements
	@FindBy(css = ".price") WebElement assertPrice;
	
	//Constructor
	public Mobile_Details_Xperia (WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory (driver, 15), this);
	}
	
	//Actions
	public String assert_Xperia_Price() {
		return assertPrice.getText();
	}
	
}
