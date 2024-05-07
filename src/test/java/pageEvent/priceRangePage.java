package pageEvent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.TestBase;

public class priceRangePage extends TestBase{
	
	@FindBy(xpath="//span[@class='a-size-base a-color-base' and text()='₹10,000 - ₹20,000']")
	WebElement PriceRange;
	
	//List<WebElement> wholePrice=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	
	@FindBy(xpath="//span[@class='a-price-whole']")
	List<WebElement> wholePrice;
	
	public priceRangePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void getPrice()
	{
		PriceRange.click();
		for(int i=0; i<wholePrice.size();i++)
		{
			String Price=wholePrice.get(i).getText();
			String finalPrice= Price.replaceAll(",","");
			System.out.println(finalPrice);
			
			int pre=Integer.parseInt(finalPrice);
			if(pre>10000 && pre<20000)
			{
				Assert.assertTrue(true, "Filter Verified");
				System.out.println("Filter Verified");
			}
			else
			{
				Assert.assertFalse(false, "Verification Failed");
			}
			
		}
	}

}
