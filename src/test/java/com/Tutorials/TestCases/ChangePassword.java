package com.Tutorials.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Tutorials.automation.Base.Base;
import com.Tutorials.automation.Pages.HomePage;
import com.Tutorials.automation.Pages.LoginPage;

public class ChangePassword extends Base {
	public WebDriver driver ;
	public ChangePassword()
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
//Validate whether user able to login after changing with new Password
	@Test
	public void ValidateChangePassword()
	{
		LoginPage Login=new LoginPage(driver);
		Login.Enterdetails("hasni@gmail.com","Hasini@96");
		Login.ClickonLogin();
		WebElement change=driver.findElement(By.linkText("Change your password"));
		WebElement continu=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", change);
		String exp="(//h1)[2][text()=\"Change Password\"]";
		Boolean value=driver.findElement(By.xpath(exp)).isDisplayed();
		jse.executeScript("document.getElementById('input-password').value='12345'");
		jse.executeScript("document.getElemenById('input-confirm').value='12345'​");
		jse.executeScript("arguments[0].click()", continu);
		Login.logoutclick("Righthand");
		HomePage home=new HomePage(driver);
		home.MyAccountAction();
		home.LoginOptionAction();
		Login.Enterdetails("hasni@gmail.com","12345");
		Login.ClickonLogin();
		
		System.out.println(value);
		
		
	}

	@Test
	public void ValidateConfirmPasswordField()
	{
		
	}
	
@AfterMethod
public void closeBrowser()
{
	driver.quit();
}
}
