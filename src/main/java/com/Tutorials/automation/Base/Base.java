package com.Tutorials.automation.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.j2objc.annotations.Property;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public WaitStatements wait=new WaitStatements();
	public Properties prop; 
	public Base()
	{
		prop=new Properties();
	File propfile=new File("C:\\Automation_scripts\\Facebook\\src\\main\\Resources\\configurationFile\\Config.properties");
	try {
	FileInputStream fis=new FileInputStream(propfile);
	prop.load(fis);
	}
	catch(Exception e)
	{
		e.getStackTrace();
	}
	
	}
	
	public WebDriver startBrowser(String browser)
	{
		
	     if(browser.equals("chrome"))
		{

			driver = new ChromeDriver();
			wait.implicity_wait(driver, 20);
			
		}
	     else if(browser.equals("Edge"))
	    	
	     {
	    	driver=new EdgeDriver();
	     }

	    	else
	    	{
	    		driver=new FirefoxDriver();
	    	}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	
	}
	public static void takescreenshot(String methodname)
	{
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+".\\screenshot"+methodname+".png";
		try {
			FileUtils.copyFile(srcfile,new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
		
	
	
