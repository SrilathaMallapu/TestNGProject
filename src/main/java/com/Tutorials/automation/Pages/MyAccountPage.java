package com.Tutorials.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	}
	@FindBy(linkText="Change your password")
	private WebElement ChangePassword;
	
	@FindBy(document.getElementbyId('input-password'))
	private WebElement Password;
	
	
	
}
