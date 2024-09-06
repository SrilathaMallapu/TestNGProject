package com.Tutorials.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Tutorials.automation.Base.Base;
import com.Tutorials.automation.Pages.HomePage;
import com.Tutorials.automation.Pages.LoginPage;
import com.Tutorials.automation.listeners.MyListeners;
@Listeners(MyListeners.class)
public class LogoutTest extends Base {

	WebDriver driver;
	
	
public LogoutTest()
{
	super();
}
	@BeforeMethod
	public void LaunchBrowser()
	{
		driver=startBrowser(prop.getProperty("browser"));
		
		HomePage home=new HomePage(driver);
		LoginPage Login=new LoginPage(driver);
		home.MyAccountAction();
		home.LoginOptionAction();
		Login.Enterdetails("Hasni@gmail.com", "Hasini@96");
	    Login.ClickonLogin();
	}
	
	@Test
	public void ValidateLogoutOption()
	{
		LoginPage Login=new LoginPage(driver);
		Assert.assertTrue(Login.LogoutDisplay());
	}
	
	@Test
	public void validateLogoutOption()
	{
		LoginPage Login=new LoginPage(driver);
		Login.logoutclick("Button");
		Assert.assertTrue(Login.ValidateLogout());
	}
	@Ignore
	@Test
	public void validateHomePage()
	{
		Actions act = new Actions(driver);
		SoftAssert sft=new SoftAssert();
		LoginPage Login=new LoginPage(driver);
		Login.logoutclick("Righthand");
		Login.continueclick();
		sft.assertFalse(driver.findElement(By.linkText("Qafox.com")).isDisplayed());
		HomePage home=new HomePage(driver);
		home.MyAccountAction();
		home.LoginOptionAction();
		Login.Enterdetails("hasni@gmail.com", "Hasini@96");
		act.sendKeys(Keys.ENTER).perform();
		sft.assertTrue(Login.LogoutDisplay());
		sft.assertAll();
	}
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}
	
	
}
