package com.Tutorials.automation.listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners implements ITestListener{

	
	ExtentReports extent;
	ExtentTest extenttest;
	@Override
	public void onTestStart(ITestResult result) {
		
		String testName=result.getName();
		extenttest=extent.createTest(testName);
		extenttest.log(Status.INFO,testName+"started successsfully");
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName=result.getName();
		extenttest=extent.createTest(testName);
		extenttest.log(Status.PASS,testName+"completed  successsfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getName();
		extenttest=extent.createTest(testName);
		WebDriver driver = null;
		try {
			
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		File Screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Destination=System.getProperty("user.dir")+"\\Screenshot"+testName+".png";
		try {
			FileHandler.copy(Screenshot,new File(Destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenttest.addScreenCaptureFromPath(Destination);
		extenttest.log(Status.FAIL, testName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=result.getName();
		System.out.println("Test got skipped"+ testName);
	}

	@Override
	public void onStart(ITestContext context) {
		extent=ExtentReporter.generateReporter();
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	
	

}
