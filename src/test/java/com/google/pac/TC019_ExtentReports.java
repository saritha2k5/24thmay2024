package com.google.pac;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC019_ExtentReports {
	@Test
	public void extentrport() throws IOException
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportname="Test-Report-"+timestamp+".html";
		String screenshot="Screenshot"+timestamp+".png";
	ExtentReports extent=new ExtentReports();
	ExtentSparkReporter spark=new ExtentSparkReporter(reportname);
	extent.attachReporter(spark);
	ExtentTest test=extent.createTest("Lauch Browser");
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	WebElement ele=driver.findElement(By.name("q"));
	TakesScreenshot TS=(TakesScreenshot)driver;
	File sourcefile=TS.getScreenshotAs(OutputType.FILE);
	File destfile=new File("./screenshots/"+screenshot);
	FileUtils.copyFile(sourcefile, destfile);
	
	if(ele.isDisplayed())
	{	
	test.pass("pass");
	System.out.println("./screenshots/"+screenshot);
	test.addScreenCaptureFromPath("./screenshots/"+screenshot);
	
	}
	else
	{
			
	test.fail("failed");
	}
			extent.flush();
	}
	
	

	
	
	

}
