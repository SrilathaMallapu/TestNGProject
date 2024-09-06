package com.Tutorials.automation.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Tutorials.automation.Base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners extends Base implements ITestListener{

	
	ExtentReports extent;
	ExtentTest extenttest;
	@Override
	public void onTestStart(ITestResult result) {
		
		String testName=result.getName();
		System.out.println("TestMethod has started"+testName);	//extenttest=extent.createTest(testName);
		//extenttest.log(Status.INFO,testName+"started successsfully");
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName=result.getName();
		System.out.println("Test method got succeded"+testName);
		//extenttest=extent.createTest(testName);
		//extenttest.log(Status.PASS,testName+"completed  successsfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getName();
		//WebDriver driver = null;
		//extenttest=extent.createTest(testName);
		
		takescreenshot(testName);
	System.out.println("Testgotfaliled");
	
	}

	
		

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=result.getName();
		System.out.println("Test got skipped"+ testName);
	}

	@Override
	public void onStart(ITestContext context) {
		//extent=ExtentReporter.generateReporter();
	}

	@Override
	public void onFinish(ITestContext context) {
		//extent.flush();
	}
	
	
	

}
