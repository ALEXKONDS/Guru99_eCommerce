package eCommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProductComparePage {

	//Elements
	@FindBy(xpath = "//h1[contains(text(),'Compare Products')]") WebElement textAssert_Compare;
	
	//Constructor
		public ProductComparePage (WebDriver driver) {
			PageFactory.initElements(new AjaxElementLocatorFactory (driver, 15), this);
		}
		
		
		//Actions
		public String return_textAssert_Compare() {
			return textAssert_Compare.getText();
		}
	
}
