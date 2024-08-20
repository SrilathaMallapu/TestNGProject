package com.Tutorials.TestCases;
import com.Tutorials.automation.utils.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import com.Tutorials.automation.Base.Base;
import com.Tutorials.automation.Pages.HomePage;
import com.Tutorials.automation.Pages.RegisterPage;
import com.Tutorials.automation.utils.EmailGeneration;

public class RegisterTest extends Base
{
	
public WebDriver chrome;
public RegisterTest()
{
	super();
}
/*WebElement Account;
WebElement Register;
WebElement FirstName,LastName,Email,Telephone,Password,Confirm;*/

@BeforeMethod
public void LaunchBrowser()
{
	chrome=startBrowser(prop.getProperty("browser"));
	HomePage home=new HomePage(chrome);
home.MyAccountAction();
home.RegisterOptionAction();

}
@Ignore
@Test(priority=1)
public void RegisterValidCredentials()
{
	
	SoftAssert sft=new SoftAssert();
RegisterPage regis=new RegisterPage(chrome);
regis.SendData("hello","world","wordl@gmail.com","234567890", "worldhari", "worldhari" );
regis.privacy();
regis.ConButon();
sft.assertTrue(chrome.findElement(By.linkText("Success")).isDisplayed());
sft.assertAll();
}

@Test
public void RegisterWithExistedCredentials()
{
	SoftAssert sft=new SoftAssert();
	RegisterPage regis=new RegisterPage(chrome);
	regis.SendData("hello","world","wordl@gmail.com","234567890", "worldhari", "worldhari" );
	regis.privacy();
	regis.ConButon();
	
  String ActualWaringMessage=chrome.findElement(By.xpath("//div[contains(@class,' alert-dismissible')]")).getText();
  sft.assertTrue(ActualWaringMessage.contains("Warning: E-Mail Address is already registered!"),"Expected Warning message is not displayed");
	
	sft.assertAll();
}


@Test
public void RegisterInvalidPassword()
{
	SoftAssert sft=new SoftAssert();
	RegisterPage regis=new RegisterPage(chrome);
	regis.SendData("hello","world","wordl@gmail.com","234567890", "worldhari", "worldhari2" );
	regis.privacy();
	regis.ConButon();
	String PasswordMismatch=chrome.findElement(By.className("text-danger")).getText();
	sft.assertEquals(PasswordMismatch,"Password confirmation does not match password!");
	sft.assertAll();
}

@Test
public void RegisterInvalidCredentials()
{
	SoftAssert sft=new SoftAssert();
	/*chrome.findElement(By.id("input-firstname")).sendKeys("Marina");
	chrome.findElement(By.id("input-lastname")).sendKeys("Garita");
	chrome.findElement(By.id("input-email")).sendKeys("Mari@getting.com");
	chrome.findElement(By.id("input-telephone")).sendKeys("234567851");
	//chrome.findElement(By.id("input-password")).sendKeys("Mari@345");
	chrome.findElement(By.id("input-confirm")).sendKeys("Mari@345");
	//chrome.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();*/
	RegisterPage regis=new RegisterPage(chrome);
	regis.ConButon();
	
    String PrivacyPolicy=chrome.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	sft.assertTrue(PrivacyPolicy.contains("Warning: You must agree to the Privacy Policy!"),"expected message is not displayed");
	//String FristNameWarning=chrome.findElement(By.xpath(""))
	sft.assertAll();
}

@AfterMethod
public void CloseBrowser()
{
	chrome.quit();
}
}