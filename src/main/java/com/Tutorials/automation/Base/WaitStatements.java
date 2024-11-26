package com.Tutorials.automation.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatements {

	#This are changes need to be committed
	public void implicity_wait(WebDriver driver,int timeout)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		
	}
	#this is change one
	public void Explicitwait(WebDriver driver,int timeout,WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
}
