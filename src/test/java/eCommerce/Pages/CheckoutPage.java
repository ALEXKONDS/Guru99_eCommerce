package eCommerce.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CheckoutPage {
	
	//Elements
	@FindBy(css = "input[title='Qty']") WebElement txtQuantity;
	@FindBy(css = "li[class='error-msg'] ul li span") WebElement msgError;
	@FindBy(xpath = "//span[contains(text(),'Empty Cart')]") WebElement btnEmptyCart;
	@FindBy(tagName = "h1") WebElement msgEmptyCart;
	
	
	//Constructor
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory (driver, 15), this);
	}
	
	
	//Actions
	public void editQuantity(Integer quantity) {
		txtQuantity.clear();
		txtQuantity.sendKeys(quantity.toString() + Keys.ENTER);
	}
	
	public String assert_ReturnMsgError() {
		return msgError.getText();
	}
	
	public void btn_EmptyCart() {
		btnEmptyCart.click();
	}
	
	public String assert_ReturnMsgEmptyCart() {
		return msgEmptyCart.getText();
	}
	
}
