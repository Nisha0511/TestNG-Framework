package pageEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class FilterValidationPage extends TestBase{
	
	//("//span[@class='a-size-base a-color-base' and text()=\"Redmi\"]")).click();
	
	@FindBy(xpath="//span[@class='a-size-base a-color-base' and text()=\"Redmi\"]")
	WebElement filterText;
	
	public FilterValidationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void filterValidation()
	{
		filterText.click();
		
	}
	
	

}
