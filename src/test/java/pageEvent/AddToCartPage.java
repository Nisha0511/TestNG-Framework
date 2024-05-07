package pageEvent;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class AddToCartPage extends TestBase{
			
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	
	List<WebElement> allProduct;
	

	@FindBy(id="add-to-cart-button")
	List<WebElement> addToCart;
	
	@FindBy(id="add-to-cart-button")
WebElement singleaddToCart;
	//id="attach-sidesheet-checkout-button-announce"
	
	@FindBy(id="attach-accessory-proceed-to-checkout-text")
	WebElement checkOut;
	
	public AddToCartPage()
	{
		PageFactory.initElements(driver,this);
	}
			

	public void clickOnProduct()
	{
		allProduct.get(0).click();
		
		
	}
	
	public void switchWindow()
	{
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
	}
	
	public void clickOnAddToCart() throws InterruptedException
	{
		Thread.sleep(5000);
		if(addToCart.size()>1)
		{
			int size=addToCart.size();
		addToCart.get(size-(1)).click();
		}
		
		else {
			singleaddToCart.click();
		}
		checkOut.click();
	}
}
