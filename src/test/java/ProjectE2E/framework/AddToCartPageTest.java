package ProjectE2E.framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageEvent.AddToCartPage;
import pageEvent.AmazonLoginPage;
import pageEvent.ProductSearchPage;
import testBase.ExtentTestManager;
import testBase.TestBase;

public class AddToCartPageTest extends TestBase {
	AmazonLoginPage alp;
	ProductSearchPage productSearch;
	AddToCartPage cartPage;
	
	@BeforeMethod
	public void initializeBrowser()
	{
		initiateBrowser();
		alp = new AmazonLoginPage();
		productSearch = new ProductSearchPage();
		cartPage= new AddToCartPage();
	}
	
	@Test(priority=0)
	public void addToCartMethod() throws InterruptedException
	{
		alp.login("7320996522","P1@inDian");
		productSearch.searchProduct();
		cartPage.clickOnProduct();
		cartPage.switchWindow();
		cartPage.clickOnAddToCart();
		ExtentTestManager.getTest().log(Status.INFO,"Failed add to cart").addScreenCaptureFromPath(screenshot("AddToCart.png"));

		
		
	}
	
	@AfterMethod
	public void teardown()
	
	{
		driver.quit();
	}

}
