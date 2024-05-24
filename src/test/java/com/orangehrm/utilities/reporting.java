package com.orangehrm.utilities;
	import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class reporting implements ITestListener {
		
		public ExtentSparkReporter htmlsparkreporter;
		public ExtentReports extent;
		public ExtentTest test;
		@Override
		public void onTestStart(ITestResult result) {
			String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportname="Test-Report-"+timestamp+".html";
		htmlsparkreporter=new ExtentSparkReporter("C:\\Saritha\\Saritha\\Batch1\\Aug16thSelenium\\reports\\"+reportname);
		extent=new ExtentReports();
		extent.attachReporter(htmlsparkreporter);
		htmlsparkreporter.config().setDocumentTitle("Orange HRM Project");
		
		
		
		}
		@Override
		public void onTestSuccess(ITestResult result) {
			test=extent.createTest(result.getName());
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
			
					}
		@Override
		public void onTestFailure(ITestResult result) {
			
			test=extent.createTest(result.getName());
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			String projectpath=System.getProperty("user.dir");
			String screenshotpath="C:\\Saritha\\Saritha\\Batch1\\Aug16thSelenium\\screenshots\\"+result.getName()+".png";
			File f1=new File(screenshotpath);
			if(f1.exists())
			{
				try
				{
					test.fail("Screenshot is below"+test.addScreenCaptureFromPath(screenshotpath));
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
							
				}
			
			}
		}
		
		
		@Override
		public void onFinish(ITestContext context) {
			extent.flush();
			
		}
		
		


			
		

	
}
