package com.Tutorials.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPage {

	WebDriver driver;
	public ForgotPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement Email;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement failure;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement success;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div[2]/input")
	private WebElement continu;
	
	public void inputdata(String email)
	{
		Email.sendKeys(email);
	}
	
	public String getdata()
	{
		String successdata=success.getText();
		return successdata;
	}
	public String faildata()
	{
		String faildata=failure.getText();
		return faildata;
		
	}
	public void contin()
	{
		continu.click();
	}

	
}
