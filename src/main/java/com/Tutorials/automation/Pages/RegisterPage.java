package com.Tutorials.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement FirstName;
	
	@FindBy(id="input-lastname")
	private WebElement LastName;
	
	@FindBy(id="input-email")
	private WebElement Email;
	
	@FindBy(id="input-telephone")
	private WebElement Telephone;
	
	@FindBy(id="input-password")
	private WebElement Password;
	
	@FindBy(id="input-confirm")
	private WebElement confirm;
	
	@FindBy(name="agree")
	private WebElement Privacy;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	private WebElement conButon;
	
	public void SendData(String First,String Last,String email,String phone,String Pass,String con)
	{
	FirstName.sendKeys(First);
	LastName.sendKeys(Last);
	Email.sendKeys(email);
	Telephone.sendKeys(phone);
	Password.sendKeys(Pass);
	confirm.sendKeys(con);
	
	}
	public void privacy()
	{
		Privacy.click();
	}
	
	public void ConButon()
	{
		conButon.click();
	}
	
}
