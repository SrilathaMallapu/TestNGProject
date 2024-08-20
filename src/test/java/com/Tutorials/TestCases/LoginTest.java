package com.Tutorials.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import com.Tutorials.automation.Base.Base;
import com.Tutorials.automation.Pages.HomePage;
import com.Tutorials.automation.Pages.LoginPage;

public class LoginTest extends Base
{
	public WebDriver driver ;
	public LoginTest()
	{
		super();
	}
	@BeforeMethod
	public void LaunchBrowser()
	{
		driver=startBrowser(prop.getProperty("browser"));
	HomePage home=new HomePage(driver);
	home.MyAccountAction();
	home.LoginOptionAction();
	}
	
	
   	@Test
	public void Validatecredential() throws InterruptedException
	{
   		
   		SoftAssert sft = new SoftAssert();
   		LoginPage Login=new LoginPage(driver);
	Login.Enterdetails("Hasni@gmail.com","Hasini@96");
	Login.ClickonLogin();
	sft.assertTrue(Login.Displayed());
	
	//sft.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]/text()")).isDisplayed());

	sft.assertAll();
	}
	
	@Test
	public void InValidatecredential() throws InterruptedException
	{
		
	LoginPage Login=new LoginPage(driver);
	Login.Enterdetails("hasini@gmail.com","12345");
	Login.ClickonLogin();
	String warningMessage=Login.Warning();
	String expectedWarning_Message="Warning: No match for E-Mail Address and/or Password.";
	Assert.assertTrue(warningMessage.contains(expectedWarning_Message),"Expected warning Message not dispalyed");
	//sft.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]/text()")).isDisplayed());

	//sft.assertAll();

		
}
	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
	}
}

