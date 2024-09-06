package com.Tutorials.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[2]/div/form/div[1]/input")
	private WebElement EmailAddress;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	private WebElement Password;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input[1]")
	private WebElement LoginButton;
	@FindBy(linkText="Edit your account information")
	private WebElement Success;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement Error;
	@FindBy(linkText="Forgotten Password")
	private WebElement Forgot;
	@FindBy(linkText="Logout")
	private WebElement Logout;
	@FindBy(linkText="My Account")
	private WebElement MyAccount;
	@FindBy(linkText="Login")
	private WebElement Loginlink;
	@FindBy(linkText="Continue")
	private WebElement ContinueButton;
	@FindBy(xpath="//div[@class=\"list-group\"]/a[13]")
	private WebElement LogoutRight;

	public void Enterdetails(String str,String str2)
	{
		
		EmailAddress.sendKeys(str);
		Password.sendKeys(str2);
	}
	
	public void ClickonLogin()
	{
		LoginButton.click();
	}
		
	public boolean Displayed()
	{
		Boolean value=Success.isDisplayed();
		return value;
	}
	public String Warning()
	{
		String WarningMessage= Error.getText();
		return WarningMessage;
	}
	public void Forgotclick()
	{
		Forgot.click();
	}
	public boolean LogoutDisplay()
	{
		MyAccount.click();
		return Logout.isDisplayed();
	}
	public void logoutclick(String option)
	{
		Actions act=new Actions(driver);
		if(option.equals("Button"))
		{
		Logout.click();
		}
		else if(option.equals("Righthand"))
		{
			act.moveToElement(LogoutRight).click().build().perform();
		}
	}
	public boolean ValidateLogout()
	{
		MyAccount.click();
		return Loginlink.isDisplayed();
	}
	public void continueclick()
	{
		ContinueButton.click();
	}
	
}
