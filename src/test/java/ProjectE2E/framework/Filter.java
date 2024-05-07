package ProjectE2E.framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Filter {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
ChromeOptions option = new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();

		driver.findElement(By.id("ap_email")).sendKeys("7320996522");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("P1@inDian");
		driver.findElement(By.id("signInSubmit")).click();
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile");
		driver.findElement(By.xpath("//div[@class='nav-right']/div/span")).click();
		Thread.sleep(3000);
		try {
		WebElement expandText=driver.findElement(By.xpath("//a[@class='a-size-base a-link-normal sf-collapsible-left-nav-expand-all a-text-bold']"));
		expandText.click();
		}
		
		catch(Exception e)
		{
			
		WebElement collapseText=driver.findElement(By.xpath("//a[@class='a-size-base a-link-normal sf-collapsible-left-nav-collapse-all aok-float-right a-text-bold']"));
		
		collapseText.click();
		WebElement expandText=driver.findElement(By.xpath("//a[@class='a-size-base a-link-normal sf-collapsible-left-nav-expand-all a-text-bold']"));
		expandText.click();
		}
		
		finally
		{
			
		
		/*if(expandText.isEnabled())
		{
			expandText.click();
		}
		else {
		
			collapseText.click();
			expandText.click();
		}*/
		
		/*
		 * try { //driver.findElement(By.
		 * xpath("//span[@class='a-size-base a-color-base puis-bold-weight-text' and text()='Brand']"
		 * )).click(); //li[@class='a-spacing-micro' and @aria-label='Redmi']
		 * driver.findElement(By.
		 * xpath("//span[@class='a-size-base a-color-base' and text()=\"Redmi\"]")).
		 * click(); } catch(Exception e) {
		 */
			driver.findElement(By.xpath("//span[@class='a-size-base a-color-base' and text()=\"Redmi\"]")).click();
			
		
		//driver.findElement(By.xpath("//span[@class='a-size-base a-color-base a-text-bold' and text()='Redmi']")).click();
		
		}
List<WebElement> prod = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

for(int i=0; i<prod.size(); i++)
{
	String element=prod.get(i).getText();
	
	System.out.println(element);
	
	if(!element.contains("Redmi"))
	{
		Assert.fail();
	}
	
	else {
		Assert.assertTrue(true);
	}
}

	
	

	
driver.quit();
		//*[@id="p_89/Redmi"]/span/a/span
	}

}
