package ProjectE2E.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageEvent.AmazonLoginPage;
import pageEvent.ProductSearchPage;
import testBase.ExtentTestManager;
import testBase.TestBase;

public class ProductSearchPageTest extends TestBase {
	
	AmazonLoginPage alp;
	ProductSearchPage product;
	
	@BeforeMethod
	public void launchURL()
	{
		initiateBrowser();
		
		alp=new AmazonLoginPage();
		product=new ProductSearchPage();
	}
	
	@Test(priority=0)
	public void productSearch()
	{
		alp.login("7320996522","P1@inDian");
		product.searchProduct();

		ExtentTestManager.getTest().log(Status.INFO, "Searched product succdessfully").addScreenCaptureFromPath(screenshot("Searched product.png"));
}

}