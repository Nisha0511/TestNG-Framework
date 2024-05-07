package ProjectE2E.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginNegativeCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
ChromeOptions option = new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in");
		
		driver.findElement(By.xpath("//span[@class='nav-line-1 nav-progressive-content' and text()='Hello, sign in']")).click();
		
		driver.findElement(By.cssSelector("input[class='a-input-text a-span12 auth-autofocus auth-required-field']")).sendKeys("Suhani Mishra");
		driver.findElement(By.cssSelector(".a-button-input")).click();
		Thread.sleep(3000);
		WebElement alert =driver.findElement(By.xpath("//div[@class='a-alert-content']/ul/li/span"));
		String actualText=alert.getText();
		System.out.println(actualText);
		String expectedText="We cannot find an account with that email address";
		Assert.assertEquals(actualText, expectedText);

	}

}
