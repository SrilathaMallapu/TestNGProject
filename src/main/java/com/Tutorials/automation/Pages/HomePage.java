package com.Tutorials.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
private WebElement MyAccount;

@FindBy(linkText="Login")
private WebElement LoginOption;

@FindBy(linkText="Register")
private WebElement RegisterOption;

//Actions 

public void MyAccountAction()
{
	MyAccount.click();
	
}
public void LoginOptionAction()
{
	LoginOption.click();
}
public void RegisterOptionAction()
{
	RegisterOption.click();
}
}
