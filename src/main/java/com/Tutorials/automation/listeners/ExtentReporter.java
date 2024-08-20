package com.Tutorials.automation.listeners;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	public static ExtentReports generateReporter()
	{
		ExtentReports extent =new ExtentReports();
		File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\extentreports\\extentreport.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Automatio Report");
		sparkReporter.config().setDocumentTitle("Automation_Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extent.attachReporter(sparkReporter);
		return extent;
	}
}
