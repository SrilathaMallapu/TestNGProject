package com.Tutorials.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public void Enterdetails(String email,String Pass)
	{
		EmailAddress.sendKeys(email);
		Password.sendKeys(Pass);
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
}
