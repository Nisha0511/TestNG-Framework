package ProjectE2E.framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageEvent.AmazonLoginPage;
import pageEvent.FilterValidationPage;
import pageEvent.ProductSearchPage;
import testBase.ExtentTestManager;
import testBase.TestBase;

public class FilterValidationPageTest extends TestBase{
	AmazonLoginPage alp;
	ProductSearchPage product;
	FilterValidationPage filterPage;
	
	@BeforeMethod
	public void launchURL()
	{
		initiateBrowser();
		alp= new AmazonLoginPage();
		product = new ProductSearchPage();
		filterPage= new FilterValidationPage();
	}
	
@Test(priority=0)
	public void filterValidation()
	{
		alp.login("7320996522","P1@inDian");
		product.searchProduct();
		filterPage.filterValidation();
		ExtentTestManager.getTest().log(Status.INFO, "Filter is working as expected").addScreenCaptureFromPath(screenshot("FilterValidation.png"));
	}
	
@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
