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

public class PriceRange {

	public static void main(String[] args) {
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
		
		
		//driver.findElement(By.xpath("//span[@class='a-size-base a-color-base a-text-bold' and text()='₹10,000 - ₹20,000']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"p_36/1318506031\"]/span/a/span")).click();
		List<WebElement> wholePrice=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		for(int i=0; i<wholePrice.size(); i++)
		{
			String price= wholePrice.get(i).getText();
			String finalPrice= price.replaceAll(",","");
			
			System.out.println(finalPrice);
			int pri = Integer.parseInt(finalPrice);
			
			if(pri>20000&&pri<25000)
			{
				Assert.assertTrue(true, "Filter Verified");
				System.out.println("Filter Verified");
			}
			else {
				Assert.assertFalse(false, "filter not working");
				System.out.println("Verification failed");
			}
			
		}
	}

}
