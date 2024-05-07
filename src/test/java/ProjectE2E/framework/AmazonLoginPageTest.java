package ProjectE2E.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Utils.ExcelReader;
import pageEvent.AmazonLoginPage;
import testBase.ExtentTestManager;
import testBase.TestBase;

public class AmazonLoginPageTest extends TestBase {
	String ValidUsername=ExcelReader.getTestData("ValidSignIn", "Username", Global.TestDataPath);
	//String validPassword=ExcelReader.getTestData("ValidSignIn", "Password", Global.TestDataPath);
	
	
	AmazonLoginPage alp;
	
	@BeforeMethod
	public void launchURL()
	{
		initiateBrowser();
		
		alp=new AmazonLoginPage();
	}
	
	@Test(priority=0)
	public void ValidsignIn()
	{
		String validPassword=ExcelReader.getTestData("ValidSignIn", "Password", Global.TestDataPath);
		System.out.println(validPassword);
		alp.login(ValidUsername,validPassword);
	String actualaccountName=alp.getAccountName();
	Assert.assertEquals(actualaccountName,"Hello, Suhani");
	screenshot("ValidSignIn.png");
	ExtentTestManager.getTest().log(Status.INFO, "account login successfully");
		
	}
	
	@Test(priority=1)
	public void InvalidSignIn()
	{
		alp.login("7320996522", "A1@inDian");
		String actualText= alp.verifyAlert();
		String expectedText="Your password is incorrect";
		Assert.assertEquals(actualText, expectedText);
		screenshot("InvalidSignIn.png");
		ExtentTestManager.getTest().log(Status.INFO, "User is getting error while login").addScreenCaptureFromPath(screenshot("InvalidSignIn.png"));
		
		
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
