package com.Tutorials.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.Tutorials.automation.Base.Base;
import com.Tutorials.automation.Pages.ForgotPage;
import com.Tutorials.automation.Pages.HomePage;
import com.Tutorials.automation.Pages.LoginPage;

@Ignore
public class ForgotTest extends Base{

	WebDriver driver;
	public ForgotTest()
	{
		super();
	}
	
	@BeforeMethod
	public void launchBrowser() {
		driver=startBrowser("chrome");
		HomePage home=new HomePage(driver);
		home.MyAccountAction();
		home.LoginOptionAction();
		LoginPage login=new LoginPage(driver);
		login.Forgotclick();
		
	}
	
	@Test
	public void TestwithvalidCredentials()
	{
		ForgotPage form=new ForgotPage(driver);
		form.inputdata("Hasni@gmail.com2");
		form.contin();
		String fail=form.faildata();
		//Assert.assertTrue(Success.contains("An email with a confirmation link has been sent your email address"));
			Assert.assertTrue(fail.contains("The E-Mail Address was not found in our records, please try again!"));	
	}
	@Test
	public void TestwithInvalidCredentails()
	{
		ForgotPage form=new ForgotPage(driver);
		form.inputdata("Hasni@gmail.com");
		form.contin();
		String success=form.getdata();
		Assert.assertTrue(success.contains("An email with a confirmation link has been sent your email address."));
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
}
