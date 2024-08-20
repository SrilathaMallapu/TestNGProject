package com.Tutorials.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
public SearchPage(WebDriver driver)	
{

this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(name="search")
private WebElement SearchField;

@FindBy(xpath="//div[@id='search']/descendant::button")
private WebElement SearchButton;


public void SendwithValid(String value)
{
	SearchField.sendKeys(value);
}
public void SendwithInvalid(String value)
{
	SearchField.sendKeys(value);
}
public void searchvalue()
{
	SearchButton.click();
}
}
