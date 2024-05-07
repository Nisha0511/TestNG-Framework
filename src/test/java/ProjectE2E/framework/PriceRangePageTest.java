package ProjectE2E.framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageEvent.AmazonLoginPage;
import pageEvent.ProductSearchPage;
import pageEvent.priceRangePage;
import testBase.ExtentTestManager;
import testBase.TestBase;

public class PriceRangePageTest extends TestBase {
	public AmazonLoginPage alp;
	public ProductSearchPage product;
	public priceRangePage price;
	
	@BeforeMethod
	public void initializeDriver()
	{
		initiateBrowser();
		alp= new AmazonLoginPage();
		product= new ProductSearchPage();
		price= new priceRangePage();
	}
	
	@Test(priority=0)
	public void priceRange()
	{
		alp.login("7320996522", "P1@inDian");
		product.searchProduct();
		price.getPrice();
		ExtentTestManager.getTest().log(Status.INFO, "PriceRangeValidated").addScreenCaptureFromPath(screenshot("priceRangeValidated.png"));
		
	}
	

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
}
