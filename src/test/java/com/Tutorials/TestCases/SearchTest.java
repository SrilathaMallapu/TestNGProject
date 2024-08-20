package com.Tutorials.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Tutorials.automation.Base.Base;
import com.Tutorials.automation.Pages.SearchPage;

public class SearchTest extends Base {

	public WebDriver driver;
	public SearchTest()
	{
		super();
	}
	@BeforeMethod
	public void LaunchBrowser()
	{
		driver=startBrowser(prop.getProperty("browser"));
		
	}
	
	@Test
	public void SearchwithExistingProduct()
	{
		SearchPage searchcate = new SearchPage(driver);
		searchcate.SendwithValid("HP");
		searchcate.searchvalue();
	Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"Element you are searching for not available");
	}
	
	@Test
	public void searchwithNonExisitngProduct()
	{
		SearchPage searchcate = new SearchPage(driver);
		searchcate.SendwithValid("Honda");
		searchcate.searchvalue();
		String WarningMessage=driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText();
		Assert.assertEquals(WarningMessage,"There is no product that matches the search criteria.","Expected warnging message is not dispalyed");
	}
	@Test
	public void searchwithNoproduct()
	{
		SearchPage searchcate = new SearchPage(driver);
		searchcate.SendwithValid("");
		searchcate.searchvalue();
		String WarningMessage=driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText();
		Assert.assertEquals(WarningMessage,"There is no product that matches the search criteria.","Expected warnging message is not dispalyed");
	}
	@AfterMethod
	public void Closebrowser()
	{
		driver.quit();
	}
	
}
