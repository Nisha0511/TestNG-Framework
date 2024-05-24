package pageEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;



public class AmazonLoginPage extends TestBase{
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement signInbutton;
	
	@FindBy(id="ap_email")
	WebElement username;
	
	@FindBy(id="continue")
	WebElement Continue;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement submit;
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement accountName;
	
	@FindBy(xpath="//div[@class='a-alert-content']/ul/li/span")
	WebElement alert;
	
	
	//Login page
	public AmazonLoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login(String Username, String Password)
	{
		signInbutton.click();
		username.sendKeys(Username);
		Continue.click();
		password.sendKeys(Password);
		submit.click();
	}
	
	public String getAccountName()
	{
		return accountName.getText();
		
	}
	
	public String verifyAlert()
	{
		return alert.getText();
		
	}

}
