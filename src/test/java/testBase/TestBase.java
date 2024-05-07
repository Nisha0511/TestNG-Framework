package testBase;




import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import ProjectE2E.framework.Global;
import Utils.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase  {
	
	public static WebDriver driver;

	public static void initiateBrowser() {
		//ChromeOptions option = new ChromeOptions();

		   ChromeOptions options = new ChromeOptions();
	        options.addArguments("disable-infobars");
	        options.addArguments("--lang=en");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage");
	        options.addArguments("--start-maximized");
	        options.addArguments("--disable-popup-blocking");
	        WebDriverManager.chromedriver().clearDriverCache().setup();
	        driver = new ChromeDriver(options);
	        String url=ExcelReader.getTestData("ValidSignIn", "URL", Global.TestDataPath);
	        System.out.println(url);
	        driver.get(url);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	
	public static String screenshot(String fileName)
	{
		String screenshotPath= System.getProperty("user.dir") +"\\abc\\screenshots\\"+"\\";
		
		File src = new File(screenshotPath);
		src.mkdir();
		
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destinationFile=new File(screenshotPath + fileName);
			try {
				
			FileUtils.copyFile(scrFile,destinationFile);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return destinationFile.getAbsolutePath();
	}
	
		
		

	}


