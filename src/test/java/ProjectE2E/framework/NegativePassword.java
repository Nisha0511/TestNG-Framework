package ProjectE2E.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NegativePassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in");
		
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		driver.findElement(By.id("ap_email")).sendKeys("7320996522");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys("test@123");
		driver.findElement(By.id("signInSubmit")).click();
		
		WebElement alert= driver.findElement(By.xpath("//div[@class='a-alert-content']/ul/li/span"));
		String actualText= alert.getText();
		System.out.println(actualText);
		
		String expectedText="Your password is incorrect";
		Assert.assertEquals(actualText, expectedText);
		
		
		

	}

}
