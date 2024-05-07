package pageEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class ProductSearchPage extends TestBase {
	
	
	//driver.findElement(By.id("c")).sendKeys("Mobile");
	
	@FindBy(id="twotabsearchtextbox")
	WebElement search;
	
	@FindBy(xpath="//div[@class='nav-right']/div/span")
	WebElement searchIcon;
	
public ProductSearchPage()
{
	PageFactory.initElements(driver, this);
}

public void searchProduct()
{
	search.sendKeys("mobile");
	searchIcon.click();
}

}
