package eCommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchMobilePage {

	//Elements
	@FindBy(id = "product-collection-image-1") WebElement imgDetailsXperia;
	@FindBy(id = "product-price-1") WebElement assertPriceXperia;	
	@FindBy(css = "body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(2) > li:nth-child(3) > div:nth-child(2) > div:nth-child(4) > button:nth-child(1)") WebElement btnAddToCart_Xperia;
	@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/select[1]") WebElement dropSortBy;

	
	//Constructor
	public SearchMobilePage (WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory (driver, 15), this);
	}
	
	
	//Actions
	public void sortBy_Name(String sort) {
		Select dropSort = new Select(dropSortBy);
		dropSort.selectByValue(sort);
	}
	
	public String assert_Price_Xperia() {
		return assertPriceXperia.getText();
	}
	
	public void goto_Details_Xperia() {
		imgDetailsXperia.click();
	}
	
	public void addToCart_Xperia() {
		btnAddToCart_Xperia.click();
	}
}
